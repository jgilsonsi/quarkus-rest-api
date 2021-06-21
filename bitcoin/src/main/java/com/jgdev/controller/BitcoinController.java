package com.jgdev.controller;

import com.jgdev.model.Bitcoin;
import com.jgdev.service.BitcoinService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bitcoins")
@Slf4j
public class BitcoinController {

    @Inject
    @RestClient
    BitcoinService bitcoinService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bitcoin> listAll() {
        log.info("[Bitcoin] GET all items");
        return bitcoinService.listAll();
    }
}
