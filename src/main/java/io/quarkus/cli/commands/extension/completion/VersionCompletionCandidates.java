package io.quarkus.cli.commands.extension.completion;

import java.util.Iterator;

public class VersionCompletionCandidates extends AbstractCompletionCandidates {

    @Override
    public Iterator<String> iterator() {
        return getRegistry().getVersions().iterator();
    }
}
