package io.quarkus.cli.commands.registry;

import picocli.CommandLine;

@CommandLine.Command(name = "registry", description = "Registry-based commands",
        mixinStandardHelpOptions = true,
        subcommands = {RegistryAddCommand.class, RegistryListCommand.class})
public class RegistryCommand {
}
