package io.quarkus.cli.commands.registry;

import picocli.CommandLine;

@CommandLine.Command(name = "registry", description = "Registry-based commands", subcommands = {AddRegistryCommand.class, ListRegistriesCommand.class})
public class RegistryCommand {
}
