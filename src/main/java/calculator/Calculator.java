package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static calculator.ExceptionMessage.*;
import static calculator.MathSymbol.*;
import static calculator.view.Input.inputMathExpression;
import static calculator.view.Output.outputStartMessage;
import static calculator.view.Output.resultOutput;

public class Calculator {
    private static final String NOT_NUMBER_PATTERN = "[^0-9]";
    private static final String THE_END_IS_NOT_NUMBER = "[0-9]*$";
    private static final String IS_NOT_MATH_EXPRESSION = "[^0-9+\\-*/]";
    private static final String MAKE_EMPTY = "";
    private static final int HAVE_NOT_APPENDED_NUMBER = 1;

    public void printResult() {
        Calculator calculator = new Calculator();
        outputStartMessage();
        resultOutput(calculator.makeResult(makeSlicedMathExpression()));
    }

    public double calculate(double firstNumber, String operator, double secondNumber) {
        return findValidatedSymbol(operator).operate(firstNumber, secondNumber);
    }

    private double makeResult(List<String> mathExpressions) {
        double result = Double.parseDouble(mathExpressions.get(0));
        int mathExpressionSize = mathExpressions.size();

        for (int i = 1; i < mathExpressionSize; i += 2) {
            String operator = mathExpressions.get(i);
            double number = Double.parseDouble(mathExpressions.get(i + 1));
            result = calculate(number, operator, result);
        }
        return result;
    }

    private List<String> makeSlicedMathExpression() {
        String enteredMathExpression = inputMathExpression();
        validate(enteredMathExpression);
        String[] slicedMathExpression = sliceMathExpression(enteredMathExpression);
        List<String> slicedMathExpressions = convertSplitExpressionArrayToList(slicedMathExpression);
        return slicedMathExpressions;
    }

    private void validate(String mathExpression) {
        isInputNull(mathExpression);
        isNotMathExpression(mathExpression);
        isTheEndNotNumber(mathExpression);
    }

    private void isTheEndNotNumber(String mathExpression) {
        if (Pattern.matches(THE_END_IS_NOT_NUMBER, mathExpression)) {
            throw new IllegalArgumentException(THE_END_IS_NOT_NUMBER_MESSAGE);
        }
    }

    private void isNotMathExpression(String mathExpression) {
        if (Pattern.matches(IS_NOT_MATH_EXPRESSION, mathExpression)) {
            throw new IllegalArgumentException(IS_NOT_MATH_EXPRESSION_MESSAGE);
        }
    }

    private void isInputNull(String mathExpression) {
        if (mathExpression.trim().isEmpty()) {
            throw new IllegalArgumentException(DO_NOT_INPUT_NULL_MESSAGE);
        }
    }

    private String[] sliceMathExpression(String mathExpression) {
        return mathExpression.split("");
    }

    private List<String> convertSplitExpressionArrayToList(String[] splitMathExpression) {
        List<String> mathExpressions = new ArrayList<>();
        String integerOfMathExpression = MAKE_EMPTY;

        for (String mathSymbol : splitMathExpression) {
            if (isNotNumberPattern(mathSymbol)) {
                mathExpressions.add(integerOfMathExpression);
                mathExpressions.add(mathSymbol);
                integerOfMathExpression = MAKE_EMPTY;
                continue;
            }
            integerOfMathExpression = integerOfMathExpression.concat(mathSymbol);
        }
        if (haveIntegerExpression(integerOfMathExpression)) {
            mathExpressions.add(integerOfMathExpression);
        }
        return mathExpressions;
    }

    private boolean isNotNumberPattern(String mathSymbol) {
        if (Pattern.matches(NOT_NUMBER_PATTERN, mathSymbol)) {
            return true;
        }
        return false;
    }

    private boolean haveIntegerExpression(String integerOfMathExpression) {
        if (integerOfMathExpression.length() >= HAVE_NOT_APPENDED_NUMBER) {
            return true;
        }
        return false;
    }
}