package calculator;

import java.util.Arrays;

import static calculator.ExceptionMessage.IS_NOT_MATH_EXPRESSION_MESSAGE;

public enum MathSymbol {
    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLE("*");

    private final String mathSymbol;

    MathSymbol(String mathSymbol) {
        this.mathSymbol = mathSymbol;
    }

    public String getMathSymbol() {
        return mathSymbol;
    }

    public static MathSymbol findValidatedSymbol(String operator) {
        return Arrays.stream(MathSymbol.values())
                .filter(mathSymbol -> mathSymbol.getMathSymbol().equals(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자 입니다."));
    }

    public double operate(double firstNumber, double secondNumber) {
        if (PLUS.getMathSymbol() == this.getMathSymbol()) {
            return firstNumber + secondNumber;
        }
        if (MINUS.getMathSymbol() == this.getMathSymbol()) {
            return firstNumber - secondNumber;
        }
        if (MULTIPLE.getMathSymbol() == this.getMathSymbol()) {
            return firstNumber * secondNumber;
        }
        if (DIVIDE.getMathSymbol() == this.getMathSymbol()) {
            return firstNumber / secondNumber;
        }
        throw new IllegalArgumentException(IS_NOT_MATH_EXPRESSION_MESSAGE);
    }
}
