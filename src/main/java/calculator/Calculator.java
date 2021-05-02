package calculator;


import calculator.view.Input;
import calculator.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static calculator.Exception.*;
import static calculator.view.Output.startMessageOutput;

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

        startMessageOutput();
        String mathExpression = input.mathExpressionInput();

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
//        String[] splitMathExpressionByChar = mathExpression.split("");
        List<String> mathExpressionList = new ArrayList<String>();
        String temp = "";
        for (String s : splitMathExpression) {
            if (Pattern.matches("[^0-9]", s)) {
                mathExpressionList.add(temp);
                mathExpressionList.add(s);
                temp = "";
            } else {
                temp = temp.concat(s);
            }
        }
        if (temp.length() >= 1) {
            mathExpressionList.add(temp);
        }
        return mathExpressionList;
    }

    private double makeResult(List<String> mathExpressionList) {
        double number;
        String fourRule;
        double result = Double.parseDouble(mathExpressionList.get(0));
        int listSize = mathExpressionList.size();
        for (int i = 1; i < listSize; i += 2) {
            fourRule = mathExpressionList.get(i);
            number = Double.parseDouble(mathExpressionList.get(i + 1));
            result = calculate(number, fourRule, result);
        }
        return result;
    }

    private double calculate(double number, String splitWord, double result) {
        CalculatorFunction calculatorFunction = new CalculatorFunction();
        Exception exception = new Exception();

        if (splitWord.equals("+")) {
            result = calculatorFunction.addNumber(result, number);
        } else if (splitWord.equals("-")) {
            result = calculatorFunction.subtractNumber(result, number);
        } else if (splitWord.equals("*")) {
            result = calculatorFunction.multipleNumber(result, number);
        } else if (splitWord.equals("/")) {
            result = calculatorFunction.divideNumber(result, number);
        } else if (Pattern.matches("[^0-9]", splitWord)) {
            exception.notFourRuleException();
        }
        return result;
    }
}