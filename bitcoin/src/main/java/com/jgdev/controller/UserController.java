package com.jgdev.controller;

import com.jgdev.enums.RoleType;
import com.jgdev.model.User;
import com.jgdev.service.UserService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/users")
@Slf4j
public class UserController {

    @Inject
    UserService userService;

    @POST
    @PermitAll
    @Transactional
    @Consumes(APPLICATION_JSON)
    public void create(User user) {
        log.info("[User] Creating user: {}", user.getUsername());
        userService.create(user);
    }

    @GET
    @RolesAllowed(RoleType.ADMIN_ROLE)
    @Produces(APPLICATION_JSON)
    public List<User> readAll() {
        return userService.getAll();
    }
}
