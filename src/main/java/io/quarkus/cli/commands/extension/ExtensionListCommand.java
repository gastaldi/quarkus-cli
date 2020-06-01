package io.quarkus.cli.commands.extension;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import javax.inject.Inject;

import io.quarkus.extensions.catalog.model.registry.Extension;
import io.quarkus.extensions.catalog.model.registry.Registry;
import picocli.CommandLine;

@CommandLine.Command(name = "list", description = "List the available extensions")
public class ExtensionListCommand implements Runnable {

    private static final String CONCISE_FORMAT = "%-50s %-50s";

    @CommandLine.Unmatched
    List<String> keyword;

    @Inject
    Registry registry;

    @Override
    public void run() {
        final Predicate<Extension> filter;
        if (keyword == null || keyword.isEmpty() || keyword.get(0).equals("*")) {
            filter = extension -> true;
        } else {
            final Pattern searchPattern = Pattern.compile(".*" + keyword.get(0) + ".*", Pattern.CASE_INSENSITIVE);
            filter = extension -> searchPattern.matcher(extension.getName()).matches();
        }
        registry.getExtensions().stream().sorted(Comparator.comparing(Extension::getName))
                .filter(filter)
                .map( extension -> String.format(CONCISE_FORMAT, extension.getName(), extension.getId().getGroupArtifactId()))
                .forEach(System.out::println);
    }
}
