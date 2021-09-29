package com.hoang.demoBidirectional.bidirectional.multiThreading;

import com.hoang.demoBidirectional.bidirectional.GrpcExampleClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TaskExecutorInit {

    private class initConnectTask implements Runnable {
        public initConnectTask() {
        }

        @Override
        public void run() {
            try {
                TaskExecutorInit.this.grpcExampleClient.initConnect();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Autowired
    GrpcExampleClient grpcExampleClient;

    @Autowired
    TaskExecutor taskExecutor;

    public void create() {
        taskExecutor.execute(new initConnectTask());
    }
}

