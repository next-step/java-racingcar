package calculator;

import com.sun.istack.internal.NotNull;
import com.*;

import java.math.BigInteger;

public class Number {

    private BigInteger mValue;

    Number(BigInteger value) {
        mValue = value;
    }

    public Number plus(@NotNull Number number) {
        ValidationUtils.assertNull(number);
        return new Number(mValue.add(number.mValue));
    }

    public BigInteger getValue() {
        return mValue;
    }
}
