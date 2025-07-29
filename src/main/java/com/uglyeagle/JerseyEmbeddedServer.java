package com.uglyeagle;

import java.io.IOException;
import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyEmbeddedServer {

    public static final String BASE_URI = "http://localhost:8080/jersey/api/";

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig()
                .packages("com.uglyeagle.controller", "com.uglyeagle.exception");

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println("Jersey app started at " + BASE_URI);
        System.out.println("Press Enter to stop the server...");
        System.in.read();
        server.shutdownNow();
    }
}


// jersey-container-simple-http
// jersey-container-jetty-http
// jersey-container-netty-http
// can also be used instead of grizzly container
// in such case com.uglyeagle.JerseyEmbeddedServer class implementation will vary w.r.t the api used