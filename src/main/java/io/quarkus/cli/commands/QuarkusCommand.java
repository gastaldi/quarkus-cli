package io.quarkus.cli.commands;

import io.quarkus.cli.commands.extension.ExtensionCommand;
import io.quarkus.cli.commands.registry.RegistryCommand;
import io.quarkus.picocli.runtime.annotations.TopCommand;
import picocli.AutoComplete;
import picocli.CommandLine;

@TopCommand
@CommandLine.Command(mixinStandardHelpOptions = true,
        name = "quarkus",
        version = {"Quarkus CLI v1.0.0.Alpha1"},
        subcommands = {RegistryCommand.class, ExtensionCommand.class, AutoComplete.GenerateCompletion.class})
public class QuarkusCommand {
}
