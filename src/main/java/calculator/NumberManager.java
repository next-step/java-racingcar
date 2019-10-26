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
}
