
package com.uglyeagle.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class JerseyImpl {

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHelloRoot() {
        return "Hello, World!";
    }

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, World!";
    }

    @GET
    @Path("json")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonResponse() {
        return "{\"message\": \"Hello, JSON!\"}";
    }

    @GET
    @Path("xml")
    @Produces(MediaType.APPLICATION_XML)
    public String getXmlResponse() {
        return "<message>Hello, XML!</message>";
    }

    
}
