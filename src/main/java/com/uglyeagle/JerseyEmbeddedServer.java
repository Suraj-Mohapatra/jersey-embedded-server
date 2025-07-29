package com.uglyeagle;

import java.net.URI;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.simple.SimpleContainerFactory;

public class JerseyEmbeddedServer {

    public static final String BASE_URI = "http://localhost:8080";

    public static void main(String[] args) throws Exception {
        final ResourceConfig config = new ResourceConfig()
                .packages("com.uglyeagle.controller", "com.uglyeagle.exception");

        // Start Simple HTTP Server
        var container = SimpleContainerFactory.create(URI.create(BASE_URI), config);

        System.out.println("Jersey app started at " + BASE_URI);
        System.out.println("Press Enter to stop the server...");
        System.in.read();

        container.close();  // Properly stop the server
    }
}
