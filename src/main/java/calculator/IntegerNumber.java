package calculator;

import com.sun.istack.internal.NotNull;

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

    BigInteger getValue() {
        return mValue;
    }

    @Override
    public Number plus(Number number) {
        ValidationUtils.assertNull(number);

        BigInteger addResult = mValue.add(getBigIntegerFrom(number));
        return new IntegerNumber(addResult);
    }

    @Override
    public Number minus(Number number) {
        return plus(number.toNegative());
    }

    @Override
    public Number multiply(Number number) {
        ValidationUtils.assertNull(number);

        BigInteger multiplyResult = mValue.multiply(getBigIntegerFrom(number));
        return new IntegerNumber(multiplyResult);
    }

    @Override
    public Number divide(Number number) {
        ValidationUtils.assertNull(number);

        BigInteger divideResult = mValue.divide(getBigIntegerFrom(number));
        return new IntegerNumber(divideResult);
    }

    @Override
    public Number toNegative() {
        return new IntegerNumber(mValue.negate());
    }

    @Override
    public String toString() {
        return mValue.toString();
    }

    // 실수 -> 정수로의 변환은 불가능하다.
    private static BigInteger getBigIntegerFrom(@NotNull Number number) {
        if (number instanceof IntegerNumber) {
            IntegerNumber integerNumber = (IntegerNumber) number;
            return integerNumber.getValue();
        }

        throw new IllegalArgumentException();
    }
}
