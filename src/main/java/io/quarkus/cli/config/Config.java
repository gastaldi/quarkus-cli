package io.quarkus.cli.config;

import java.net.URI;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class Config {

    @Inject
    @ConfigProperty(name = "quarkus.cli.registries")
    List<URI> registries;

    public List<URI> getRegistries() {
        return registries;
    }

    public void addRegistry(URI registry) {

    }
}
