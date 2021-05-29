package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.ExceptionMessage.*;
import static calculator.MathSymbol.*;
import static calculator.view.Input.inputMathExpression;
import static calculator.view.Output.outputStartMessage;
import static calculator.view.Output.resultOutput;

public class Calculator {
    private static final String IS_MATH_SYMBOL_REGEX = "[^0-9]";
    private static final String IS_THE_END_NOT_NUMBER_REGEX = "[0-9]*$";
    private static final String IS_WRONG_MATH_EXPRESSION_REGEX = "[^0-9+\\-*/]";
    private static final String MAKE_EMPTY = "";
    private static final int HAVE_NOT_APPENDED_NUMBER = 1;
    private static final int SYMBOL_INDEX_INTERVAL = 2;
    private static final int NUMBER_INDEX_INTERVAL = 1;
    private static final int FIRST_NUMBER_INDEX = 0;
    private static final Pattern IS_MATH_SYMBOL_PATTERN = Pattern.compile(IS_MATH_SYMBOL_REGEX);
    private static final Pattern IS_THE_END_NOT_NUMBER_PATTERN = Pattern.compile(IS_THE_END_NOT_NUMBER_REGEX);
    private static final Pattern IS_WRONG_MATH_EXPRESSION_PATTERN = Pattern.compile(IS_WRONG_MATH_EXPRESSION_REGEX);

    public void printResult() {
        outputStartMessage();
        resultOutput(makeResult(makeSlicedMathExpression()));
    }

    public double calculate(double firstNumber, String operator, double secondNumber) {
        return findValidatedSymbol(operator).operate(firstNumber, secondNumber);
    }

    private double makeResult(List<String> mathExpressions) {
        double result = Double.parseDouble(mathExpressions.get(FIRST_NUMBER_INDEX));
        int mathExpressionSize = mathExpressions.size();

        for (int i = 1; i < mathExpressionSize; i += SYMBOL_INDEX_INTERVAL) {
            String operator = mathExpressions.get(i);
            double number = Double.parseDouble(mathExpressions.get(i + NUMBER_INDEX_INTERVAL));
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
        validateInputNull(mathExpression);
        validateWrongMathExpression(mathExpression);
        validateTheEndNotNumber(mathExpression);
    }

    private void validateTheEndNotNumber(String mathExpression) {
        Matcher matcher = IS_THE_END_NOT_NUMBER_PATTERN.matcher(mathExpression);
        boolean isEndNotNumber = matcher.matches();
        if (isEndNotNumber) {
            throw new IllegalArgumentException(IS_THE_END_NOT_NUMBER_MESSAGE);
        }
    }

    private void validateWrongMathExpression(String mathExpression) {
        Matcher matcher = IS_WRONG_MATH_EXPRESSION_PATTERN.matcher(mathExpression);
        boolean isNotMathExpression = matcher.matches();
        if (isNotMathExpression) {
            throw new IllegalArgumentException(IS_WRONG_MATH_EXPRESSION_MESSAGE);
        }
    }

    private void validateInputNull(String mathExpression) {
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

        for (String mathExpression : splitMathExpression) {
            if (isMathSymbol(mathExpression)) {
                mathExpressions.add(integerOfMathExpression);
                mathExpressions.add(mathExpression);
                integerOfMathExpression = MAKE_EMPTY;
                continue;
            }
            integerOfMathExpression = integerOfMathExpression.concat(mathExpression);
        }
        if (haveIntegerExpression(integerOfMathExpression)) {
            mathExpressions.add(integerOfMathExpression);
        }
        return mathExpressions;
    }

    private boolean isMathSymbol(String mathExpression) {
        Matcher matcher = IS_MATH_SYMBOL_PATTERN.matcher(mathExpression);
        return matcher.matches();
    }

    private boolean haveIntegerExpression(String integerOfMathExpression) {
        return integerOfMathExpression.length() >= HAVE_NOT_APPENDED_NUMBER;
    }
}