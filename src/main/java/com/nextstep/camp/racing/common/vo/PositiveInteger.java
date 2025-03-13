package com.nextstep.camp.racing.common.vo;

import com.nextstep.camp.racing.domain.exception.NegativeNumberException;
import com.nextstep.camp.racing.domain.exception.NotNumberException;
import com.nextstep.camp.racing.common.utils.NumberUtils;

public class PositiveInteger {
    private final int value;

    private PositiveInteger(String stringValue) {
        validateNotNumber(stringValue);
        int value = Integer.parseInt(stringValue);
        validateNegative(value);
        this.value = value;
    }

    private static void validateNegative(int value) {
        if (NumberUtils.isNegativeNumber(value)) {
            throw new NegativeNumberException();
        }
    }

    private static void validateNotNumber(String string) {
        if (NumberUtils.isNotNumber(string)) {
            throw new NotNumberException();
        }
    }

    public static PositiveInteger of(String value) {
        return new PositiveInteger(value);
    }

    public int value() {
        return value;
    }
}
