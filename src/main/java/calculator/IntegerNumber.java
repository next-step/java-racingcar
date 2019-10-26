package calculator;

import com.sun.istack.internal.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;

public class IntegerNumber implements Number {

    private BigInteger mValue;

    IntegerNumber(int value) {
        this(String.valueOf(value));
    }

    IntegerNumber(long value) {
        this(String.valueOf(value));
    }

    private IntegerNumber(@NotNull String value) {
        this(new BigInteger(value));
    }

    private IntegerNumber(@NotNull BigInteger value) {
        mValue = value;
    }

    @Override
    public Number plus(Number number) {
        return null;
    }

    @Override
    public Number minus(Number number) {
        return null;
    }

    @Override
    public Number multiply(Number number) {
        return null;
    }

    @Override
    public Number divide(Number number) {
        return null;
    }

    @Override
    public Number toNegative() {
        return null;
    }
}
