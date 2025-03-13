package com.nextstep.camp.racing.common.vo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitStrings {

    private final List<String> values;

    private SplitStrings(String[] values) {
        this.values = Arrays.asList(values);
    }

    public static SplitStrings of(String[] values) {
        return new SplitStrings(values);
    }

    public PositiveIntegers toIntegers() {
        return PositiveIntegers.of(
            values.stream()
                .map(PositiveInteger::of)
                .collect(Collectors.toList()));
    }
}
