package io.quarkus.cli.commands.extension;

import java.util.Comparator;
import java.util.Set;

import javax.inject.Inject;

import io.quarkus.extensions.catalog.model.registry.Extension;
import io.quarkus.extensions.catalog.model.registry.Registry;
import picocli.CommandLine;

@CommandLine.Command(name = "list", description = "List the available extensions")
public class ExtensionListCommand implements Runnable {

    private static final String CONCISE_FORMAT = "%-50s %-50s";

    @Inject
    Registry registry;

    @Override
    public void run() {
        registry.getExtensions().stream().sorted(Comparator.comparing(Extension::getName))
                .map( extension -> String.format(CONCISE_FORMAT, extension.getName(), extension.getId().getGroupArtifactId()))
                .forEach(System.out::println);
    }
}
