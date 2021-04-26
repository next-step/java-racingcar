package calculator;


import calculator.view.Input;
import calculator.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Calculator {

    private String setMathExpression() {
        Output output = new Output();
        Input input = new Input();
        output.startMessageOutput();
        return input.mathExpressionInput();
    }

    private List<String> sliceMathExpression(String mathExpression) {
        String[] splitMathExpression = mathExpression.split("[^0-9]");
        List<String> mathExpressionList = new ArrayList<String>();

        for(int i = 0; i < splitMathExpression.length; i++){
            mathExpressionList.add(splitMathExpression[i]);
        }
        return mathExpressionList;
    }

    private void makeResult (List<String> mathExpressionList) {
        String number = "";
        int listSize = mathExpressionList.size();
        for (int i = 0; i > listSize ; i++) {
            mathExpressionList.get(i);

        }
    }

    private double calculate(String number, String splitWord, double result) {
        Calculate calculate = new Calculate();

        if(splitWord.equals("+")){
            result = calculate.addition(result, Double.parseDouble(number));
        } else if(splitWord.equals("-")) {
            result = calculate.subtraction(result, Double.parseDouble(number));
        } else if(splitWord.equals("*")) {
            result = calculate.multiplication(result, Double.parseDouble(number));
        } else if(splitWord.equals("/")) {
            result = calculate.division(result, Double.parseDouble(number));
        }
        return result;
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        calculator.sliceMathExpression("13+2-3");
    }


}
