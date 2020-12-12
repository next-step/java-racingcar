package calculator;

import java.util.function.IntBinaryOperator;

public enum StringCalculator{
    PLUS(Integer::sum),
    MINUS((firstValue, secondValue) -> firstValue - secondValue),
    MULTIPLY((firstValue, secondValue) -> firstValue * secondValue),
    DIVISION((firstValue, secondValue) -> firstValue / secondValue);

    private final IntBinaryOperator intBinaryOperator;

    StringCalculator(IntBinaryOperator intBinaryOperator) {
        this.intBinaryOperator = intBinaryOperator;
    }

    public int applyAsInt(int left, int right) {
        return intBinaryOperator.applyAsInt(left, right);
    }


}
