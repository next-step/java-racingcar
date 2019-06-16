package stringCalculator;

import java.util.function.IntBinaryOperator;

public enum CalculateOperator {

    ADD("+", (firstNumber, secondNumber) -> firstNumber + secondNumber),
    SUBTRACT("-", (firstNumber, secondNumber) -> firstNumber - secondNumber),
    MULTIPLY("*", (firstNumber, secondNumber) -> firstNumber * secondNumber),
    DIVIDE("/", (firstNumber, secondNumber) -> {
        return divied(firstNumber, secondNumber);
    });

    private String mathematicsSymbol;
    private IntBinaryOperator expression;

    CalculateOperator(String mathematicsSymbol, IntBinaryOperator expression) {
        this.mathematicsSymbol = mathematicsSymbol;
        this.expression = expression;
    }

    public Integer calculate(int first, int second) {
        return expression.applyAsInt(first, second);
    }


    private static Integer divied(Integer firstNumber, Integer secondNumber) {
        verifyDivideZero(secondNumber);
        return firstNumber / secondNumber;
    }

    private static void verifyDivideZero(Integer number) {
        if(number == 0 ) throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
    }
}
