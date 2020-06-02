package io.quarkus.cli;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.cli.commands.registry.RegistryClient;
import io.quarkus.cli.config.Config;
import io.quarkus.extensions.catalog.model.registry.Registry;
import io.quarkus.extensions.catalog.model.registry.RegistryBuilder;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

@ApplicationScoped
public class RegistryProducer {

    @Produces
    @ApplicationScoped
    Registry setUp(Config config, ObjectMapper objectMapper) throws IOException {
        final Registry registry;
        Path path = Paths.get(System.getProperty("user.home"), ".quarkus", "registry.cache");
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        if (Files.exists(path)) {
            registry = objectMapper.readValue(path.toFile(), Registry.class);
        } else {
            RegistryBuilder builder = new RegistryBuilder();
            for (URI uri : config.getRegistries()) {
                RegistryClient client = RestClientBuilder.newBuilder()
                        .baseUri(uri).build(RegistryClient.class);
                Registry aRegistry = client.getRegistry();
                builder.addAllCategories(aRegistry.getCategories())
                        .addAllExtensions(aRegistry.getExtensions())
                        .addAllPlatforms(aRegistry.getPlatforms())
                        .addAllVersions(aRegistry.getVersions());
            }
            registry = builder.build();
            Files.createDirectories(path.getParent());
            objectMapper.writeValue(path.toFile(), registry);
        }
        return registry;
    }

}
