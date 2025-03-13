package com.nextstep.camp.racing.common.vo;

import java.util.List;

public class PositiveIntegers {
    private final List<PositiveInteger> values;

    private PositiveIntegers(List<PositiveInteger> values) {
        this.values = values;
    }

    public static PositiveIntegers of(List<PositiveInteger> values) {
        return new PositiveIntegers(values);
    }

    public int sum() {
        return values.stream()
            .mapToInt(PositiveInteger::value)
            .sum();
    }
}
