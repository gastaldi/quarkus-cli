package io.quarkus.cli.commands.registry;

import javax.inject.Inject;

import io.quarkus.cli.commands.Config;
import picocli.CommandLine;

@CommandLine.Command(name = "list", description = "List the available registries")
public class ListRegistriesCommand implements Runnable {

    @Inject
    Config config;

    @Override
    public void run() {
        config.getRegistries().forEach(System.out::println);
    }
}