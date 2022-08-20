package com.example.producingwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import example.Roots;
import example.GetRootsRequest;
import example.GetRootsResponse;

@Endpoint
public class CoeffsEndpoint {
    private static final String NAMESPACE_URI = "http://example";

    private CoeffsRepository coeffsRepository;

    @Autowired
    public CoeffsEndpoint(CoeffsRepository coeffsRepository) {
        this.coeffsRepository = coeffsRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRootsRequest")
    @ResponsePayload
    public GetRootsResponse getRoots(@RequestPayload GetRootsRequest request) {
        GetRootsResponse response = new GetRootsResponse();

        Roots roots = coeffsRepository.findRoots(request.getA(), request.getB(), request.getC());
        response.setRoots(roots);

        return response;
    }
}