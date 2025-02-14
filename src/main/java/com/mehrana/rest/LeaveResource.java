package com.mehrana.rest;

import com.mehrana.model.dto.LeaveDto;
import com.mehrana.model.dto.UpdateLeaveRequest;
import com.mehrana.service.LeaveService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("/leave")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LeaveResource {

    @Inject
    private LeaveService leaveService;

    @POST
    @Path("/create/{personnelCode}")
    public Response create(@PathParam("personnelCode") Long personnelCode, LeaveDto leaveDto) {
        try {
            leaveService.create(personnelCode, leaveDto);
            return Response.status(Response.Status.CREATED).entity("Leave created successfully").build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
    @GET
    @Path("/getAll")
    public Response getAll() {
        return Response.ok(leaveService.findAll()).build();
    }

    @PUT
    @Path("/update/{id}")
    public Response update(@PathParam("id") Long id, UpdateLeaveRequest leaveRequest) {
        try {
            leaveService.update(id, leaveRequest);
            return Response.ok("Leave updated successfully").build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        try {
            leaveService.delete(id);
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
