package com.hoang.demoBidirectional.bidirectional;

import com.google.common.util.concurrent.MoreExecutors;
import com.hoang.demoBidirectional.bidirectional.multiThreading.TaskExecutorInit;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;

@Slf4j
@Service
public class GrpcExampleServer {

    @Autowired
    GrpcExampleClientImpl grpcExampleClient;

    @Value("${grpc.host}")
    String grpcIp;

    @Value("${grpc.port}")
    Integer grpcPort;

    @Bean
    public void initServer() throws IOException, InterruptedException {
        log.info("Start server");
        ServerBuilder<NettyServerBuilder> builder = NettyServerBuilder.forAddress(new InetSocketAddress(grpcIp, grpcPort));

        Executor executor = MoreExecutors.directExecutor();
        builder.executor(executor);

        Server server = builder.addService(new ExampleServiceGrpcImpl()).build();
        log.info("Server has started");

        server.start();
        grpcExampleClient.initCommunicate();

//        TaskExecutorInit taskExecutorInit = new TaskExecutorInit();
//        taskExecutorInit.create();
        grpcExampleClient.initConnect();
//        Thread thread1 = new Thread(new TaskExecutorInit());
//        thread1.start();
        server.awaitTermination();
    }
}
