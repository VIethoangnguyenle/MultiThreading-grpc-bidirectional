package com.hoang.demoBidirectional.bidirectional.multiThreading;

import com.hoang.demoBidirectional.bidirectional.GrpcExampleClient;

public abstract class AbstractThreading {
    private final GrpcExampleClient grpcExampleClient;

    protected AbstractThreading(GrpcExampleClient grpcExampleClient) {
        this.grpcExampleClient = grpcExampleClient;
    }


}
