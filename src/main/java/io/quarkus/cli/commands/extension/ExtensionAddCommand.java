package io.quarkus.cli.commands.extension;

import io.quarkus.cli.Printer;
import io.quarkus.cli.commands.completion.ExtensionIdCompletionCandidates;
import picocli.CommandLine;

@CommandLine.Command(name = "add", description = "Add an extension to the build descriptor")
public class ExtensionAddCommand implements Runnable {

    @CommandLine.Parameters(completionCandidates = ExtensionIdCompletionCandidates.class)
    String extension;

    @Override
    public void run() {
        Printer.ok(" Add extension " + extension);
    }
}
