package io.quarkus.cli.config;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import io.smallrye.config.source.yaml.YamlConfigSource;
import org.eclipse.microprofile.config.spi.ConfigSource;
import org.eclipse.microprofile.config.spi.ConfigSourceProvider;

public class UserConfigSourceProvider implements ConfigSourceProvider {
    @Override
    public Iterable<ConfigSource> getConfigSources(ClassLoader forClassLoader) {
        Path path = Paths.get(System.getProperty("user.home"), ".quarkus", "config.yaml");
        try {
            if (Files.exists(path)) {
                return Collections.singletonList(
                        new YamlConfigSource(path.toString(),
                                             Files.newInputStream(path),
                                             YamlConfigSource.DEFAULT_ORDINAL + 101));
            } else {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
                return Collections.emptyList();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}