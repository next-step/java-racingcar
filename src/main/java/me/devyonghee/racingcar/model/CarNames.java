package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class CarNames {

    private final List<CarName> names;

    private CarNames(List<CarName> names) {
        Assert.notEmpty(names, "names must not empty");
        this.names = new ArrayList<>(names);
    }

    static CarNames from(List<CarName> names) {
        return new CarNames(names);
    }

    <T> List<T> map(Function<CarName, T> function) {
        return names.stream()
                .map(function)
                .collect(Collectors.toList());
    }

    List<CarName> list() {
        return Collections.unmodifiableList(names);
    }
}
