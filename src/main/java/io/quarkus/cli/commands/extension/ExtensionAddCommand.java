package io.quarkus.cli.commands.extension;

import java.util.List;

import picocli.CommandLine;

@CommandLine.Command(name = "add", description = "Add an extension to the build descriptor")
public class ExtensionAddCommand implements Runnable {

    @CommandLine.Option(names = {"e","extensions"})
    List<String> extensions;

    @Override
    public void run() {

    }
}
