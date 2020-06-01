package io.quarkus.cli.commands.registry;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.extensions.catalog.model.registry.Registry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface RegistryClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Registry getRegistry();
}
