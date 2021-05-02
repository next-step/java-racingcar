package calculator;


import calculator.view.Input;
import calculator.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static calculator.Exception.*;
import static calculator.view.Output.outputStartMessage;

public class Calculator {

    public void inputExpressionAndPrintResult() {
        Calculator calculator = new Calculator();
        Output output = new Output();

        String input = calculator.returnEnteredMathExpression();
        List<String> strings = calculator.sliceMathExpression(input);
        output.resultOutput(calculator.makeResult(strings));
    }

    private String returnEnteredMathExpression() {
        Input input = new Input();
        Exception exception = new Exception();

        outputStartMessage();
        String mathExpression = input.inputMathExpression();

        if(mathExpression.trim().isEmpty()){
            exception.inputNullException();
            throw new IllegalArgumentException(INPUT_NULL);
        }
        if (Pattern.matches("[^0-9+\\-*/]",mathExpression)){
            exception.wrongInputException();
        }
        if (Pattern.matches("[0-9]*$",mathExpression)){
            exception.wrongInputException();
        }
        return mathExpression;
    }

    private List<String> sliceMathExpression(String mathExpression) {
        String[] splitMathExpression = mathExpression.split("");
        List<String> mathExpressionList = new ArrayList<>();
        String integerOfMathExpression = "";
        for (String s : splitMathExpression) {
            if (Pattern.matches("[^0-9]", s)) {
                mathExpressionList.add(integerOfMathExpression);
                mathExpressionList.add(s);
                integerOfMathExpression = "";
                continue;
            }
                integerOfMathExpression = integerOfMathExpression.concat(s);
        }
        if (integerOfMathExpression.length() >= 1) {
            mathExpressionList.add(integerOfMathExpression);
        }
        return mathExpressionList;
    }

    private double makeResult(List<String> mathExpressionList) {
        double number;
        String operator;
        double result = Double.parseDouble(mathExpressionList.get(0));
        int listSize = mathExpressionList.size();
        for (int i = 1; i < listSize; i += 2) {
            operator = mathExpressionList.get(i);
            number = Double.parseDouble(mathExpressionList.get(i + 1));
            result = calculate(number, operator, result);
        }
        return result;
    }

    private double calculate(double number, String operator, double result) {
        CalculatorFunction calculatorFunction = new CalculatorFunction();


        if (operator.equals("+")) {
            return calculatorFunction.addNumber(result, number);
        }
        if (operator.equals("-")) {
           return calculatorFunction.subtractNumber(result, number);
        }
        if (operator.equals("*")) {
            return calculatorFunction.multipleNumber(result, number);
        }
        if (operator.equals("/")) {
            return calculatorFunction.divideNumber(result, number);
        }
        throw new IllegalArgumentException(NOT_FOUR_RULE);
    }
}