package com.example.products.services;

import com.example.gen.proto.ProductRequest;
import com.example.gen.proto.ProductResponse;
import com.example.gen.proto.ProductsGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class ProductService extends ProductsGrpc.ProductsImplBase {

    @Override
    public void getProduct(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        ProductResponse productResponse = ProductResponse.newBuilder().setName("How Google Works!")
                .setDescription("The Google Story").build();
        responseObserver.onNext(productResponse);
        responseObserver.onCompleted();
    }
}
