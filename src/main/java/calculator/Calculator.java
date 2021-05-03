package calculator;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static calculator.Exception.*;
import static calculator.view.Input.inputMathExpression;
import static calculator.view.Output.outputStartMessage;
import static calculator.view.Output.resultOutput;

public class Calculator {
    private static final String LETTER = "[^0-9]";
    private static final String THE_END_IS_NOT_NUMBER = "[0-9]*$";
    private static final String IS_NOT_MATH_EXPRESSION = "[^0-9+\\-*/]";
    private static final String MAKE_EMPTY = "";
    private static final int HAS_NUMBER = 1;

    public void inputExpressionAndPrintResult() {
        Calculator calculator = new Calculator();
        String enteredMathExpression = calculator.returnEnteredMathExpression();
        List<String> slicedMathExpressions = calculator.sliceMathExpression(enteredMathExpression);
        resultOutput(calculator.makeResult(slicedMathExpressions));
    }

    private String returnEnteredMathExpression() {
        outputStartMessage();
        String mathExpression = inputMathExpression();

        if (mathExpression.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_NULL_MESSAGE);
        }
        if (Pattern.matches(IS_NOT_MATH_EXPRESSION, mathExpression)) {
            throw new IllegalArgumentException(IS_NOT_MATH_EXPRESSION_MESSAGE);
        }
        if (Pattern.matches(THE_END_IS_NOT_NUMBER, mathExpression)) {
            throw new IllegalArgumentException(THE_END_IS_NOT_NUMBER_MESSAGE);
        }
        return mathExpression;
    }

    private List<String> sliceMathExpression(String mathExpression) {
        String[] splitMathExpression = mathExpression.split("");
        List<String> mathExpressions = new ArrayList<>();
        String integerOfMathExpression = MAKE_EMPTY;
        for (String mathSymbol : splitMathExpression) {
            if (Pattern.matches(LETTER, mathSymbol)) {
                mathExpressions.add(integerOfMathExpression);
                mathExpressions.add(mathSymbol);
                integerOfMathExpression = MAKE_EMPTY;
                continue;
            }
            integerOfMathExpression = integerOfMathExpression.concat(mathSymbol);
        }
        if (integerOfMathExpression.length() >= HAS_NUMBER) {
            mathExpressions.add(integerOfMathExpression);
        }
        return mathExpressions;
    }

    private double makeResult(List<String> mathExpressions) {
        double number;
        String operator;
        double result = Double.parseDouble(mathExpressions.get(0));
        int mathExpressionSize = mathExpressions.size();
        for (int i = 1; i < mathExpressionSize; i += 2) {
            operator = mathExpressions.get(i);
            number = Double.parseDouble(mathExpressions.get(i + 1));
            result = calculate(number, operator, result);
        }
        return result;
    }

    private double calculate(double firstNumber, String operator, double secondNumber) {
        CalculatorFunction calculatorFunction = new CalculatorFunction();


        if (operator.equals("+")) {
            return calculatorFunction.addNumber(secondNumber, firstNumber);
        }
        if (operator.equals("-")) {
            return calculatorFunction.subtractNumber(secondNumber, firstNumber);
        }
        if (operator.equals("*")) {
            return calculatorFunction.multipleNumber(secondNumber, firstNumber);
        }
        if (operator.equals("/")) {
            return calculatorFunction.divideNumber(secondNumber, firstNumber);
        }
        throw new IllegalArgumentException(IS_NOT_MATH_EXPRESSION_MESSAGE);
    }
}