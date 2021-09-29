package com.hoang.demoBidirectional.bidirectional;

import java.io.IOException;

public interface GrpcExampleClient {
    void initConnect() throws IOException, InterruptedException;
    void initCommunicate() throws InterruptedException;
}
