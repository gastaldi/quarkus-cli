package io.quarkus.cli.commands.extension;

import picocli.CommandLine;

@CommandLine.Command(name = "extension",description = "Extension-based commands",
        mixinStandardHelpOptions = true,
        subcommands = {ExtensionListCommand.class, ExtensionRemoveCommand.class, ExtensionAddCommand.class})
public class ExtensionCommand {
}
