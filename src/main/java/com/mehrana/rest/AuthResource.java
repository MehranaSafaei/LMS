//package com.mehrana.rest;
//
//import com.mehrana.dao.PersonnelDao;
//import com.mehrana.model.dto.LoginRequest;
//import com.mehrana.model.entity.Personnel;
//import jakarta.inject.Inject;
//import jakarta.ws.rs.Consumes;
//import jakarta.ws.rs.POST;
//import jakarta.ws.rs.Path;
//import jakarta.ws.rs.Produces;
//import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.core.Response;
//
//@Path("/auth")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//public class AuthResource {
//    @Inject
//    private PersonnelDao personnelDao;
//
//    @POST
//    @Path("/login")
//    public Response login(LoginRequest loginRequest) {
//        Personnel personnel = personnelDao.findByUsername(loginRequest.getUsername());
//        if (personnel == null || !BCrq) {
//
//        }
//    }
//}
