package calculator;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
    public Number plus(@Nullable Number number) {
        ValidationUtils.assertNull(number);
        BigDecimal addResult = mValue.add(NumberManager.getBigDecimalFrom(number));
        return new DecimalNumber(addResult);
    }

    @Override
    public Number minus(@Nullable Number number) {
        return plus(number.toNegative());
    }

    @Override
    public Number multiply(@Nullable Number number) {
        ValidationUtils.assertNull(number);
        BigDecimal multiplyResult = mValue.multiply(NumberManager.getBigDecimalFrom(number));
        return new DecimalNumber(multiplyResult);
    }

    @Override
    public Number divide(@Nullable Number number) {
        ValidationUtils.assertNull(number);
        BigDecimal divideResult = mValue.divide(NumberManager.getBigDecimalFrom(number), RoundingMode.HALF_UP);
        return new DecimalNumber(divideResult);
    }

    BigDecimal getValue() {
        return mValue;
    }

    @Override
    public String toString() {
        return mValue.toString();
    }

    @Override
    public Number toNegative() {
        return new DecimalNumber(mValue.negate());
    }
}
