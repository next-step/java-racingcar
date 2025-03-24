package com.nextstep.camp.racing.common.vo;

import java.util.Objects;

import com.nextstep.camp.racing.common.utils.NumberUtils;
import com.nextstep.camp.racing.domain.exception.NegativeNumberException;
import com.nextstep.camp.racing.domain.exception.NotNumberException;

public class PositiveInteger {
    private final int value;

    private PositiveInteger(Number number) {
        validateNegative(number.intValue());
        this.value = number.intValue();
    }

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

    public static PositiveInteger of(Number number) {
        return new PositiveInteger(number);
    }

    public static PositiveInteger of(String value) {
        return new PositiveInteger(value);
    }

    public int value() {
        return value;
    }

    public PositiveInteger add(PositiveInteger other) {
        return new PositiveInteger(this.value + other.value);
    }

    public PositiveInteger add(int otherInt) {
        PositiveInteger other = PositiveInteger.of(otherInt);
        return this.add(other);
    }

    public boolean isLessThan(PositiveInteger other) {
        return this.value < other.value;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        PositiveInteger that = (PositiveInteger) object;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public int compareTo(PositiveInteger positiveInteger) {
        return Integer.compare(this.value, positiveInteger.value);
    }
}
