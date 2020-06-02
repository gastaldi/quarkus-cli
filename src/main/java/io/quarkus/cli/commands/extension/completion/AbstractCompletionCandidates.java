package io.quarkus.cli.commands.extension.completion;

import io.quarkus.arc.Arc;
import io.quarkus.extensions.catalog.model.registry.Registry;

public abstract class AbstractCompletionCandidates implements Iterable<String> {

    protected Registry getRegistry() {
        return Arc.container().instance(Registry.class).get();
    }
}
