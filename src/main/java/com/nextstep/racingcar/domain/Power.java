package com.nextstep.racingcar.domain;

import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class Power implements Comparable {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;
    private static final Random RANDOM = new Random();
    private static final Comparator<Power> COMPARATOR = Comparator.comparingInt((Power power) -> power.value);
    private final int value;

    private Power(int value) {
        validation(value);
        this.value = value;
    }

    private void validation(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) throw new IllegalArgumentException();
    }

    public static Power generate() {
        return new Power(RANDOM.nextInt(10));
    }

    protected static Power generateByInt(int value) {
        return new Power(value);
    }

    public int toInt() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Power power = (Power) o;
        return value == power.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Object o) {
        return COMPARATOR.compare(this, (Power) o);
    }
}
