package com.mehrana.rest;


import com.mehrana.service.MyEntityService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("/my-entity")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MyEntityResource {
    @Inject
    MyEntityService myEntityService;


    @GET
    public Response getMyEntity() {
        myEntityService.findAll();
        return Response.ok("HELLO").build();
    }
}
