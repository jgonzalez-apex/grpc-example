package com.example.service;

import com.example.GreeterServiceGrpc;
import com.example.HelloReply;
import com.example.HelloRequest;
import io.grpc.stub.StreamObserver;

public class GreeterServiceImpl extends GreeterServiceGrpc.GreeterServiceImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        responseObserver.onNext(HelloReply.newBuilder()
                .setMessage("Hello " + request.getName() + " !!")
                .build());
        responseObserver.onCompleted();
    }
}
