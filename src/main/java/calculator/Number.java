package calculator;

import java.math.BigInteger;

public class Number {

    private BigInteger mValue;

    Number(BigInteger value) {
        mValue = value;
    }

    public BigInteger getValue() {
        return mValue;
    }
}
