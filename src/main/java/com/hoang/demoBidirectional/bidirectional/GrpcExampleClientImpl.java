package com.hoang.demoBidirectional.bidirectional;

import com.hoang.Example;
import com.hoang.ExampleServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Service
public class GrpcExampleClientImpl implements GrpcExampleClient{
    ManagedChannel channel;
    private final SecureRandom random = new SecureRandom();
    private ExampleServiceGrpc.ExampleServiceStub asyncStub;
    AtomicReference<StreamObserver<Example.RequestCall>> requestObserverRef = new AtomicReference<>();
    AtomicReference<StreamObserver<Example.DevCall>> devObserverRef = new AtomicReference<>();

    @Value("${grpc.host}")
    String grpcIp;

    @Value("${grpc.port}")
    Integer grpcPort;

    @Override
    public void initConnect() throws IOException, InterruptedException {
        log.info("Start client");
        CountDownLatch finishedLatch = new CountDownLatch(1);
        StreamObserver<Example.RequestCall> observer = getAsyncStub().connect(new StreamObserver<Example.ResponseCall>() {
            @Override
            public void onNext(Example.ResponseCall value) {

                log.info(value.getRequestId());
                log.info("client receive: {}", value.getNumRep());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                int rep = random.nextInt(50);
                log.info("Client response: {}", rep);
                log.info("_____________________________________");

                requestObserverRef.get().onNext(Example.RequestCall.newBuilder()
                        .setRequestId("client call")
                        .setNumCall(rep)
                        .build());
            }

            @Override
            public void onError(Throwable t) {
                log.info("on error");
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                log.info("on completed");
                finishedLatch.countDown();
            }
        });
        requestObserverRef.set(observer);
        observer.onNext(Example.RequestCall.getDefaultInstance());
        finishedLatch.await();
        observer.onCompleted();
    }

    @Override
    public void initCommunicate() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        StreamObserver<Example.DevCall> devCallStreamObserver = getAsyncStub().communicate(new StreamObserver<Example.SirCall>() {
            @Override
            public void onNext(Example.SirCall value) {
                log.info(value.getRequestId());
                log.info("Dev receive: {}", value.getNumCall());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                int rep = random.nextInt(50);
                log.info("Dev response: {}", rep);
                log.info("_____________________________________");

                devObserverRef.get().onNext(Example.DevCall.newBuilder()
                        .setRequestId("dev call")
                        .setNumCall(rep)
                        .build());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                log.info("on completed");
                latch.countDown();
            }
        });

        devObserverRef.set(devCallStreamObserver);
        devCallStreamObserver.onNext(Example.DevCall.getDefaultInstance());
        log.info("hereeee !!!");
        latch.await();
        devCallStreamObserver.onCompleted();
    }

    public ManagedChannel createChannel() {
        if (channel == null || channel.isShutdown()) {
            channel = ManagedChannelBuilder.forAddress(grpcIp, grpcPort).usePlaintext().keepAliveWithoutCalls(true).build();
        }
        return channel;
    }

    public ExampleServiceGrpc.ExampleServiceStub getAsyncStub() {
        if (asyncStub == null) {
            asyncStub = ExampleServiceGrpc.newStub(createChannel());
        }
        return asyncStub;
    }
}
