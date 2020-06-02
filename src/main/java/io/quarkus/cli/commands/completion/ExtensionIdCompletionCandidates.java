package io.quarkus.cli.commands.completion;

import java.util.Iterator;

import io.quarkus.extensions.catalog.model.registry.ArtifactKey;
import io.quarkus.extensions.catalog.model.registry.Extension;

public class ExtensionIdCompletionCandidates extends AbstractCompletionCandidates {
    @Override
    public Iterator<String> iterator() {
        return getRegistry().getExtensions()
                .stream()
                .map(Extension::getId)
                .map(ArtifactKey::getGroupArtifactId)
                .iterator();
    }
}
