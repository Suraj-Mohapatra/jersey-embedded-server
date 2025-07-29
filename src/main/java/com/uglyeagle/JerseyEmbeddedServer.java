package com.uglyeagle;

import io.netty.channel.Channel;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.netty.httpserver.NettyHttpContainerProvider;

import jakarta.ws.rs.core.UriBuilder;
import java.net.URI;
import java.io.IOException;

public class JerseyEmbeddedServer {

    public static final String BASE_URI = "http://localhost:8080/";

    public static void main(String[] args) throws IOException, InterruptedException {
        final ResourceConfig config = new ResourceConfig()
                .packages("com.uglyeagle.controller", "com.uglyeagle.exception");

        URI baseUri = UriBuilder.fromUri(BASE_URI).build();
        Channel serverChannel = NettyHttpContainerProvider.createServer(baseUri, config, false);

        // configured a graceful shutdown hook
        // when shut down, to make sure the Netty server channel closes cleanly so ports are released, sockets closed.
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (serverChannel != null && serverChannel.isOpen()) {
                serverChannel.close();
            }
        }));

        System.out.println("Jersey app started with Netty at " + BASE_URI);
        System.in.read();

        serverChannel.close();
        serverChannel.closeFuture().sync();
    }
}
