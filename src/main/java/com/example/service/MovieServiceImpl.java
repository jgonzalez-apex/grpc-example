package com.example.service;

import com.example.MovieRequest;
import com.example.MovieServiceGrpc;
import com.example.MovieStream;
import io.grpc.stub.StreamObserver;

import java.util.stream.IntStream;

public class MovieServiceImpl extends MovieServiceGrpc.MovieServiceImplBase {
    @Override
    public void reproduce(MovieRequest request, StreamObserver<MovieStream> responseObserver) {
        IntStream.rangeClosed(1, 100000)
                .forEach(number ->
                        responseObserver.onNext(MovieStream.newBuilder().setContent("Chunk " + number).build()));

        responseObserver.onCompleted();
    }
}
