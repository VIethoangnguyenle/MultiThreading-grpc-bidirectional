package com.hoang.demoBidirectional.bidirectional;

import com.hoang.Example;
import com.hoang.ExampleServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;

@Slf4j
public class ExampleServiceGrpcImpl extends ExampleServiceGrpc.ExampleServiceImplBase {
    SecureRandom random = new SecureRandom();

    @Override
    public StreamObserver<Example.RequestCall> connect(StreamObserver<Example.ResponseCall> responseObserver) {
       log.info("Connecting stream observer");
        return new StreamObserver<Example.RequestCall>() {
            @Override
            public void onNext(Example.RequestCall value) {
               log.info(value.getRequestId());
               log.info("Server receive number : {}", value.getNumCall());

               //Delay call
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                int rep = random.nextInt(50);
                log.info("Server response: {}", rep);
                log.info("_____________________________________");
                responseObserver.onNext(Example.ResponseCall.newBuilder()
                                .setNumRep(rep)
                        .setRequestId("server call").build());
            }

            @Override
            public void onError(Throwable t) {
               log.info("on error");
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
               log.info("on completed");
            }
        };
    }

    @Override
    public StreamObserver<Example.DevCall> communicate(StreamObserver<Example.SirCall> responseObserver) {
        return new StreamObserver<Example.DevCall>() {
            @Override
            public void onNext(Example.DevCall value) {
                log.info(value.getRequestId());
                log.info("Sir receive number : {}", value.getNumCall());

                //Delay call
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                int rep = random.nextInt(50);
                log.info("Sir response: {}", rep);
                log.info("_____________________________________");
                responseObserver.onNext(Example.SirCall.newBuilder()
                        .setNumCall(rep)
                        .setRequestId("Sir call").build());
            }

            @Override
            public void onError(Throwable t) {
                log.info("on error");
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                log.info("on completed");
            }
        };
    }
}
