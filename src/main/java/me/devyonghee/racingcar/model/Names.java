package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Names {

    private final List<Name> names;

    private Names(List<Name> names) {
        Assert.notEmpty(names, "names must not empty");
        this.names = new ArrayList<>(names);
    }

    static Names from(List<Name> names) {
        return new Names(names);
    }

    <T> List<T> map(Function<Name, T> function) {
        return names.stream()
                .map(function)
                .collect(Collectors.toList());
    }

    List<Name> list() {
        return Collections.unmodifiableList(names);
    }
}
