package com.example.server;

import com.example.service.GreeterServiceImpl;
import com.example.service.MovieServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Starting gRPC server");

        Server server = ServerBuilder
                .forPort(8085)
                .addService(new GreeterServiceImpl())
                .addService(new MovieServiceImpl())
                .build();

        server.start();

        System.out.println("gRPC server started");

        Runtime.getRuntime()
                .addShutdownHook(new Thread(server::shutdown));

        server.awaitTermination();
    }
}
