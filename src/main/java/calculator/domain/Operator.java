package calculator.domain;

import java.math.BigDecimal;
import java.math.MathContext;

public class Operator {
    public static BigDecimal addition(BigDecimal x, BigDecimal y) {
        return x.add(y);
    }

    public static BigDecimal subtraction(BigDecimal x, BigDecimal y) {
        return x.subtract(y);
    }

    public static BigDecimal multiplication(BigDecimal x, BigDecimal y) {
        return x.multiply(y, MathContext.DECIMAL64);
    }

    public static BigDecimal division(BigDecimal x, BigDecimal y) {
        return x.divide(y, MathContext.DECIMAL64);
    }
}