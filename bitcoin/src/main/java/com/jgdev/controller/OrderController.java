package com.jgdev.controller;

import com.jgdev.enums.RoleType;
import com.jgdev.model.Order;
import com.jgdev.service.OrderService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

import static com.jgdev.enums.RoleType.USER_ROLE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/orders")
@Slf4j
public class OrderController {

    @Inject
    OrderService orderService;

    @POST
    @Transactional
    @RolesAllowed(USER_ROLE)
    @Consumes(APPLICATION_JSON)
    public void create(@Context SecurityContext context, Order order) {
        log.info("[User] Creating order: {}", order.getType());
        orderService.create(context, order);
    }

    @GET
    @RolesAllowed(RoleType.ADMIN_ROLE)
    @Produces(APPLICATION_JSON)
    public List<Order> readAll() {
        return orderService.getAll();
    }
}
