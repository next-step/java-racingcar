package calculator.domain;

import java.util.List;

public class Calculator {

    private double doBinaryOperation(double number1, double number2, Operator symbol) {
        if (Operator.PLUS == symbol) {
            return Operator.PLUS.operate(number1, number2);
        }
        if (Operator.MINUS == symbol) {
            return Operator.MINUS.operate(number1, number2);
        }
        if (Operator.MULTIPLY == symbol) {
            return Operator.MULTIPLY.operate(number1, number2);
        }

        return Operator.DIVIDE.operate(number1, number2);
    }

    public double doMultipleOperation(List<Integer> numbers, List<Operator> operators) {
        double result = numbers.remove(0);
        int numberSize = numbers.size();
        for (int i = 0; i < numberSize; i++) {
            result = doBinaryOperation(result, (double) numbers.get(i), operators.get(i));
        }
        return result;
    }
}
