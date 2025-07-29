package com.uglyeagle;

import java.net.URI;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyEmbeddedServer {

    public static final String BASE_URI = "http://localhost:8080/";
    //  tried to register http://localhost:8080/jersey/api
    //  but in this way I could not register any path after http://localhost:8080
    // hence access all the endpoints appending to http://localhost:8080

    public static void main(String[] args) throws Exception {
        final ResourceConfig config = new ResourceConfig()
                .packages("com.uglyeagle.controller", "com.uglyeagle.exception");

        Server server = JettyHttpContainerFactory.createServer(URI.create(BASE_URI), config);

        try {
            server.start();
            System.out.println("Jersey app started at " + BASE_URI);
            System.out.println("Press Enter to stop the server...");
            System.in.read();
        } finally {
            server.stop();
        }
    }
}
