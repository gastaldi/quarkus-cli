package io.quarkus.cli.commands.extension;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.quarkus.cli.Printer;
import io.quarkus.cli.commands.completion.VersionCompletionCandidates;
import io.quarkus.extensions.catalog.model.registry.Extension;
import io.quarkus.extensions.catalog.model.registry.Registry;
import picocli.CommandLine;

@CommandLine.Command(name = "list", description = "List the available extensions")
public class ExtensionListCommand implements Runnable {

    private static final String CONCISE_FORMAT = "%-50s %-50s";

    @CommandLine.Option(names = {"-v", "--version"}, description = "The quarkus version to be used",
            completionCandidates = VersionCompletionCandidates.class)
    String quarkusVersion;

    @CommandLine.Parameters
    List<String> keyword;

    @Inject
    Registry registry;

    @Override
    public void run() {
        Predicate<Extension> filter;
        if (keyword == null || keyword.isEmpty() || keyword.get(0).equals("*")) {
            filter = extension -> true;
        } else {
            final Pattern searchPattern = Pattern.compile(".*" + keyword.get(0) + ".*", Pattern.CASE_INSENSITIVE);
            filter = extension -> searchPattern.matcher(extension.getName()).matches();
        }
        if (quarkusVersion != null) {
            filter = filter.and(extension -> extension.getReleases().stream().anyMatch(release -> quarkusVersion.equals(release.getQuarkusCore())));
        }
        List<String> list = registry.getExtensions().stream()
                .sorted(Comparator.comparing(Extension::getName))
                .filter(filter)
                .map(extension -> String.format(CONCISE_FORMAT, extension.getName(), extension.getId().getGroupArtifactId()))
                .collect(Collectors.toList());
        if (list.isEmpty()) {
            Printer.nok(" No extension found with the provided parameters");
        } else {
            list.forEach(System.out::println);
        }
    }

}
