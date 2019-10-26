package calculator;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.math.BigDecimal;

public class DecimalNumber implements Number {

    private BigDecimal mValue;

    DecimalNumber(float value) {
        this(String.valueOf(value));
    }

    DecimalNumber(double value) {
        this(String.valueOf(value));
    }

    private DecimalNumber(@NotNull String value) {
        this(new BigDecimal(value));
    }

    private DecimalNumber(@NotNull BigDecimal value) {
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
