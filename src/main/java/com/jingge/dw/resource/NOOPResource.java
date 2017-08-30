package com.jingge.dw.resource;

import com.jingge.dw.api.Rocket;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;

/**
 * DW needs at least one resource
 */

@Path("/noop")
@Produces(MediaType.APPLICATION_JSON)
public class NOOPResource {

    public NOOPResource() {
    }

    @GET
    @Path("/status")
    public Response getStatus(@Context HttpHeaders header) {
        return Response
                .ok()
                .build();
    }

    @GET
    @Path("/{name}")
    public Response getRocket(@PathParam("name") String name) {

        Rocket r = new Rocket();
        r.setColor("Red");
        r.setName(name);
        r.setYear(2007);

        return Response
                .ok(r)
                .build();
    }

    @GET
    @Path("/")
    public Response getRockets() {

        Rocket r = new Rocket();
        r.setColor("Red");
        r.setName("name_1");
        r.setYear(2007);

        Rocket r0 = new Rocket();
        r0.setColor("Blue");
        r0.setName("name_2");
        r0.setYear(2009);

        return Response
                .ok(Arrays.asList(r, r0))
                .build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response rocket(Rocket rocket) {

        System.out.println(rocket.toString()+ rocket.getColor());
        return Response.status(201).build();

    }
}
