package calculator;

import com.sun.istack.internal.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberManager {

    private NumberManager() {
    }

    public static Number getNumberFrom(int value) {
        return new IntegerNumber(value);
    }

    public static Number getNumberFrom(long value) {
        return new IntegerNumber(value);
    }

    public static Number getNumberFrom(double value) {
        return new DecimalNumber(value);
    }

    public static Number getNumberFrom(float value) {
        return new DecimalNumber(value);
    }

    // 실수 -> 정수로의 변환은 불가능하다.
    static BigInteger getBigIntegerFrom(@NotNull Number number) {
        if (number instanceof IntegerNumber) {
            IntegerNumber integerNumber = (IntegerNumber) number;
            return integerNumber.getValue();
        }

        throw new IllegalArgumentException();
    }

    static BigDecimal getBigDecimalFrom(@NotNull Number number) {
        if (number instanceof IntegerNumber) {
            IntegerNumber integerNumber = (IntegerNumber) number;
            return new BigDecimal(integerNumber.getValue());
        }

        if (number instanceof DecimalNumber) {
            DecimalNumber decimalNumber = (DecimalNumber) number;
            return decimalNumber.getValue();
        }

        throw new IllegalArgumentException();
    }
}
