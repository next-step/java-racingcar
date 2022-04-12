package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class NameWriter {

    private static final String DELIMITER = ",";

    private final String names;

    private NameWriter(String names) {
        Assert.hasText(names, "name text must be provided");
        this.names = names;
    }

    public static NameWriter from(String names) {
        return new NameWriter(names);
    }

    public Names names() {
        return Names.from(
                Arrays.stream(names.split(DELIMITER))
                        .map(Name::from)
                        .collect(Collectors.toList())
        );
    }
}
