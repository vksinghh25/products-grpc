package com.example.products.services;

import com.example.gen.proto.*;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

import java.util.ArrayList;
import java.util.List;

@GRpcService
public class ProductService extends ProductsGrpc.ProductsImplBase {

    private List<Product> allProducts;

    ProductService() {
        allProducts = new ArrayList<>();

        Product google = Product.newBuilder()
                .setName("How Google Works!").setDescription("The Google Story")
                .setId(123456).build();

        Product mentors = Product.newBuilder()
                .setName("Tribe of Mentors").setDescription("By Tim Ferris")
                .setId(444444).build();

        Product good2Great = Product.newBuilder()
                .setName("Good To Great").setDescription("Best Management Book")
                .setId(999999).build();

        allProducts.add(google);
        allProducts.add(mentors);
        allProducts.add(good2Great);
    }

    @Override
    public void getProduct(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {

        Product filteredProduct = allProducts.stream().filter(product -> product.getId() == request.getId())
                .findFirst().orElse(Product.newBuilder().build());
        ProductResponse productResponse = ProductResponse.newBuilder().setName(filteredProduct.getName())
                .setDescription(filteredProduct.getDescription()).build();

        responseObserver.onNext(productResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllProducts(com.example.gen.proto.EmptyParams request, StreamObserver<MultiProductResponse> responseObserver) {
        MultiProductResponse multiProductResponse = MultiProductResponse.newBuilder()
                .addAllProducts(allProducts)
                .build();

        responseObserver.onNext(multiProductResponse);
        responseObserver.onCompleted();
    }
}
