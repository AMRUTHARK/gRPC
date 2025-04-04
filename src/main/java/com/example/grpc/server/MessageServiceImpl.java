package com.example.grpc.server;

import com.example.grpc.MessageRequest;
import com.example.grpc.MessageResponse;
import com.example.grpc.MessageServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class MessageServiceImpl extends MessageServiceGrpc.MessageServiceImplBase {

    @Override
    public void sendMessage(MessageRequest request, StreamObserver<MessageResponse> responseObserver) {
        String message = request.getMessage();
        System.out.println("Received message: " + message);

        MessageResponse response = MessageResponse.newBuilder()
                .setResponse("Server received: " + message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
