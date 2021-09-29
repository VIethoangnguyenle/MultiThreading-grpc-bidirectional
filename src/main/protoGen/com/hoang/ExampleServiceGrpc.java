package com.hoang;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: example.proto")
public final class ExampleServiceGrpc {

  private ExampleServiceGrpc() {}

  public static final String SERVICE_NAME = "ExampleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.hoang.Example.RequestCall,
      com.hoang.Example.ResponseCall> getConnectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Connect",
      requestType = com.hoang.Example.RequestCall.class,
      responseType = com.hoang.Example.ResponseCall.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.hoang.Example.RequestCall,
      com.hoang.Example.ResponseCall> getConnectMethod() {
    io.grpc.MethodDescriptor<com.hoang.Example.RequestCall, com.hoang.Example.ResponseCall> getConnectMethod;
    if ((getConnectMethod = ExampleServiceGrpc.getConnectMethod) == null) {
      synchronized (ExampleServiceGrpc.class) {
        if ((getConnectMethod = ExampleServiceGrpc.getConnectMethod) == null) {
          ExampleServiceGrpc.getConnectMethod = getConnectMethod =
              io.grpc.MethodDescriptor.<com.hoang.Example.RequestCall, com.hoang.Example.ResponseCall>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Connect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hoang.Example.RequestCall.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hoang.Example.ResponseCall.getDefaultInstance()))
              .setSchemaDescriptor(new ExampleServiceMethodDescriptorSupplier("Connect"))
              .build();
        }
      }
    }
    return getConnectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.hoang.Example.DevCall,
      com.hoang.Example.SirCall> getCommunicateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Communicate",
      requestType = com.hoang.Example.DevCall.class,
      responseType = com.hoang.Example.SirCall.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.hoang.Example.DevCall,
      com.hoang.Example.SirCall> getCommunicateMethod() {
    io.grpc.MethodDescriptor<com.hoang.Example.DevCall, com.hoang.Example.SirCall> getCommunicateMethod;
    if ((getCommunicateMethod = ExampleServiceGrpc.getCommunicateMethod) == null) {
      synchronized (ExampleServiceGrpc.class) {
        if ((getCommunicateMethod = ExampleServiceGrpc.getCommunicateMethod) == null) {
          ExampleServiceGrpc.getCommunicateMethod = getCommunicateMethod =
              io.grpc.MethodDescriptor.<com.hoang.Example.DevCall, com.hoang.Example.SirCall>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Communicate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hoang.Example.DevCall.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hoang.Example.SirCall.getDefaultInstance()))
              .setSchemaDescriptor(new ExampleServiceMethodDescriptorSupplier("Communicate"))
              .build();
        }
      }
    }
    return getCommunicateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ExampleServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExampleServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExampleServiceStub>() {
        @java.lang.Override
        public ExampleServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExampleServiceStub(channel, callOptions);
        }
      };
    return ExampleServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExampleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExampleServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExampleServiceBlockingStub>() {
        @java.lang.Override
        public ExampleServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExampleServiceBlockingStub(channel, callOptions);
        }
      };
    return ExampleServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ExampleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExampleServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExampleServiceFutureStub>() {
        @java.lang.Override
        public ExampleServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExampleServiceFutureStub(channel, callOptions);
        }
      };
    return ExampleServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ExampleServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.hoang.Example.RequestCall> connect(
        io.grpc.stub.StreamObserver<com.hoang.Example.ResponseCall> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getConnectMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.hoang.Example.DevCall> communicate(
        io.grpc.stub.StreamObserver<com.hoang.Example.SirCall> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getCommunicateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getConnectMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.hoang.Example.RequestCall,
                com.hoang.Example.ResponseCall>(
                  this, METHODID_CONNECT)))
          .addMethod(
            getCommunicateMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.hoang.Example.DevCall,
                com.hoang.Example.SirCall>(
                  this, METHODID_COMMUNICATE)))
          .build();
    }
  }

  /**
   */
  public static final class ExampleServiceStub extends io.grpc.stub.AbstractAsyncStub<ExampleServiceStub> {
    private ExampleServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExampleServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExampleServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.hoang.Example.RequestCall> connect(
        io.grpc.stub.StreamObserver<com.hoang.Example.ResponseCall> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getConnectMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.hoang.Example.DevCall> communicate(
        io.grpc.stub.StreamObserver<com.hoang.Example.SirCall> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getCommunicateMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ExampleServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ExampleServiceBlockingStub> {
    private ExampleServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExampleServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExampleServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class ExampleServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ExampleServiceFutureStub> {
    private ExampleServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExampleServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExampleServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CONNECT = 0;
  private static final int METHODID_COMMUNICATE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ExampleServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ExampleServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONNECT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.connect(
              (io.grpc.stub.StreamObserver<com.hoang.Example.ResponseCall>) responseObserver);
        case METHODID_COMMUNICATE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.communicate(
              (io.grpc.stub.StreamObserver<com.hoang.Example.SirCall>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ExampleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExampleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.hoang.Example.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ExampleService");
    }
  }

  private static final class ExampleServiceFileDescriptorSupplier
      extends ExampleServiceBaseDescriptorSupplier {
    ExampleServiceFileDescriptorSupplier() {}
  }

  private static final class ExampleServiceMethodDescriptorSupplier
      extends ExampleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ExampleServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ExampleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ExampleServiceFileDescriptorSupplier())
              .addMethod(getConnectMethod())
              .addMethod(getCommunicateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
