package calculator;

import com.sun.istack.internal.NotNull;
import com.*;
import com.sun.istack.internal.Nullable;

import java.math.BigInteger;

public class Number {

    private BigInteger mValue;

    Number(BigInteger value) {
        mValue = value;
    }

    public Number plus(@Nullable Number number) {
        ValidationUtils.assertNull(number);
        return new Number(mValue.add(number.mValue));
    }

    public Number minus(@Nullable Number number) {
        return plus(number.toNegative());
    }

    public Number multiply(@Nullable Number number) {
        ValidationUtils.assertNull(number);
        return new Number(mValue.multiply(number.mValue));
    }

    public BigInteger getValue() {
        return mValue;
    }

    public Number toNegative() {
        return new Number(mValue.negate());
    }
}
