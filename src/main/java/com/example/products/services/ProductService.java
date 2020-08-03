package com.example.products.services;

import com.example.gen.proto.*;
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

    @Override
    public void getAllProducts(com.example.gen.proto.EmptyParams request, StreamObserver<MultiProductResponse> responseObserver) {
        Product good2Great = Product.newBuilder().setName("Good to Great").setDescription("Best Mgmt Book").build();
        Product howGoogleWorks = Product.newBuilder().setName("How Google Works!").setDescription("The Google Story!").build();
        Product tribeOfMentors = Product.newBuilder().setName("Tribe Of Mentors").setDescription("By Tim Ferris").build();
        Product talkLikeTed = Product.newBuilder().setName("Talk Like Ted").setDescription("Inspiration from the best speakers.").build();

        MultiProductResponse multiProductResponse = MultiProductResponse.newBuilder().addProducts(good2Great)
                .addProducts(howGoogleWorks)
                .addProducts(tribeOfMentors)
                .addProducts(talkLikeTed)
                .build();

        responseObserver.onNext(multiProductResponse);
        responseObserver.onCompleted();
    }
}
