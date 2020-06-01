package io.quarkus.cli.commands.registry;

import io.quarkus.cli.Printer;
import picocli.CommandLine;

@CommandLine.Command(name = "add", description = "Add a registry to the configuration")
public class RegistryAddCommand implements Runnable {

    @Override
    public void run() {
        Printer.ok(" Added Registry");
    }
}
