package com.mehrana.rest;

import com.mehrana.model.dto.PersonnelDto;
import com.mehrana.model.dto.UpdatePersonnelRequest;
import com.mehrana.service.PersonnelService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/personnel")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class PersonnelResource {

    @Inject
    private PersonnelService personnelService;

    @POST
    @Path("/create")
    public Response create(PersonnelDto personnelDto) {
        return Response.ok(personnelService.create(personnelDto)).build();
//         Response.status(Response.Status.CREATED)
//                .entity("Create Successfully")
//                .build();
    }

    @GET
    @Path("/getAll")
    public Response getAll() {
        return Response.ok(personnelService.findAll()).build();
    }

    @GET
    @Path("/username/{username}")
    public Response getByUsername(@PathParam("username") String username) {
        try {
            PersonnelDto personnel = personnelService.findByUsername(username);
            return Response.ok(personnel).build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Personnel not found with username: " + username)
                    .build();
        }
    }

    @GET
    @Path("/id/{id}")
    public Response getById(@PathParam("id") Long id) {
        try {
            PersonnelDto personnel = personnelService.findById(id);
            return Response.ok(personnel).build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Personnel not found with ID: " + id)
                    .build();
        }
    }

    @PUT
    @Path("/update/by-id/{id}")
    public Response updateById(@PathParam("id") Long id, UpdatePersonnelRequest personnelRequest) {
        try {
            personnelService.updateById(id, personnelRequest);
            return Response.status(Response.Status.OK)
                    .entity("Update Successfully")
                    .build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Personnel not found with ID: " + id)
                    .build();
        }
    }

    @PUT
    @Path("/update/by-code/{personnelCode}")
    public Response updateByPersonnelCode(@PathParam("personnelCode") Long personnelCode, UpdatePersonnelRequest request) {
        try {
            personnelService.updateByPersonnelCode(personnelCode, request);
            return Response.status(Response.Status.OK)
                    .entity("Update Successfully")
                    .build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Personnel not found with code: " + personnelCode)
                    .build();
        }
    }


    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        try {
            personnelService.delete(id);
            return Response.status(Response.Status.OK)
                    .entity("Delete Successfully")
                    .build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Personnel not found with ID: " + id)
                    .build();
        }
    }
}
