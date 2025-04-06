package com.mehrana.auth;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/jwt")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class LmsJwtResource {

    @Inject
    private LmsJwtService jwtService;

    @GET
    public Response getJwt(){
        String jwt = jwtService.generateJwt();
        return Response.ok(jwt).build();
    }
}
