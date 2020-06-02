package io.quarkus.cli.commands.extension;

import io.quarkus.cli.Printer;
import io.quarkus.cli.commands.extension.completion.ExtensionIdCompletionCandidates;
import picocli.CommandLine;

@CommandLine.Command(name = "add", description = "Add an extension to the build descriptor")
public class ExtensionAddCommand implements Runnable {

    @CommandLine.Option(names = {"-e","--extension"}, completionCandidates = ExtensionIdCompletionCandidates.class)
    String extension;

    @Override
    public void run() {
        Printer.ok(" Add extension "+ extension);
    }
}
