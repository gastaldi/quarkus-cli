package io.quarkus.cli.commands;

import io.quarkus.cli.commands.extension.ExtensionCommand;
import io.quarkus.cli.commands.registry.RegistryCommand;
import io.quarkus.picocli.runtime.annotations.TopCommand;
import picocli.CommandLine;

@TopCommand
@CommandLine.Command(mixinStandardHelpOptions = true, subcommands = {RegistryCommand.class, ExtensionCommand.class})
public class QuarkusCommand {
}
