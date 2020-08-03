# Simple Products Service using gRPC

Exposes one single query to return 1 single product. 

## Getting Started

1. Get the project and run mvn compile. This generates the file from the .proto definition. 
2. Run the project as a Springboot project. 


## Deployment

Add additional notes about how to deploy this on a live system.

## Details

1. products.proto defines that structure of the request/response and the service call. 
2. @GRpcService annotation is used to define the service. 
3. Modify grpc.port property to change the port from the default of 6565. 

