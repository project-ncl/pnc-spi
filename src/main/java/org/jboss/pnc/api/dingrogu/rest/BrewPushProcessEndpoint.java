package org.jboss.pnc.api.dingrogu.rest;

import org.jboss.pnc.api.dingrogu.dto.StartBrewPushRequest;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Path("/process/brew-push")
public interface BrewPushProcessEndpoint {

    @POST
    @Path("/start")
    void startPush(@Valid StartBrewPushRequest request);
}
