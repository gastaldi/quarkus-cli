package io.quarkus.cli.commands.registry;

import java.net.URI;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import io.quarkus.cli.commands.Config;
import io.quarkus.extensions.catalog.model.registry.Registry;
import io.quarkus.extensions.catalog.model.registry.RegistryBuilder;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

@ApplicationScoped
public class RegistryProducer {

    @Produces
    @ApplicationScoped
    private Registry setUp(Config config) {
        RegistryBuilder builder = new RegistryBuilder();
        // TODO: Fetch from URL only if not cached locally previously
        for (URI uri : config.getRegistries()) {
            RegistryClient client = RestClientBuilder.newBuilder().baseUri(uri).build(RegistryClient.class);
            Registry aRegistry = client.getRegistry();
            builder.addAllCategories(aRegistry.getCategories())
                    .addAllExtensions(aRegistry.getExtensions())
                    .addAllPlatforms(aRegistry.getPlatforms())
                    .addAllVersions(aRegistry.getVersions());
        }
        return builder.build();
    }

}
