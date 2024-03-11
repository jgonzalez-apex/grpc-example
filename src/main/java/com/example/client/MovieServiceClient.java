package com.example.client;

import com.example.MovieRequest;
import com.example.MovieServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MovieServiceClient {
    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8085)
                .usePlaintext()
                .build();

        MovieServiceGrpc.MovieServiceBlockingStub stub = MovieServiceGrpc.newBlockingStub(managedChannel);

        stub.reproduce(MovieRequest.newBuilder().setName("Titanic").build())
                .forEachRemaining(movieStream -> System.out.println(movieStream.getContent()));
    }
}
