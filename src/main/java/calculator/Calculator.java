package calculator;


import calculator.view.Input;
import calculator.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Calculator {

    private String setMathExpression() {
        Output output = new Output();
        Input input = new Input();
        output.startMessageOutput();
        return input.mathExpressionInput();
    }

    private List<String> sliceMathExpression(String mathExpression) {
        String[] splitMathExpression = mathExpression.split("");
//        String[] splitMathExpressionByChar = mathExpression.split("");
        List<String> mathExpressionList = new ArrayList<String>();
        String temp = "";
        for (int i = 0; i < splitMathExpression.length; i++) {
            if (Pattern.matches("[^0-9]", splitMathExpression[i])) {
                mathExpressionList.add(temp);
                mathExpressionList.add(splitMathExpression[i]);
                temp = "";
            } else {
                temp += splitMathExpression[i];
            }
        }
        if (temp.length() >= 1) {
            mathExpressionList.add(temp);
        }

        return mathExpressionList;
    }

    private double makeResult(List<String> mathExpressionList) {
        String splitWord = "";
        String number = "";
        double result = Double.parseDouble( mathExpressionList.get(0));
        int listSize = mathExpressionList.size();
        for (int i = 1; i < listSize; i++) {
//            숫자면 result {수식} 숫자 연산
            if (Pattern.matches("[0-9]", mathExpressionList.get(i))) {
                number = mathExpressionList.get(i);
                result = calculate(number, splitWord, result);
            } else {
                splitWord = mathExpressionList.get(i);


            }
        }
        return result;
    }

    private double calculate(String number, String splitWord, double result) {
        Calculate calculate = new Calculate();

        if (splitWord.equals("+")) {
            result = calculate.addition(result, Double.parseDouble(number));
        } else if (splitWord.equals("-")) {
            result = calculate.subtraction(result, Double.parseDouble(number));
        } else if (splitWord.equals("*")) {
            result = calculate.multiplication(result, Double.parseDouble(number));
        } else if (splitWord.equals("/")) {
            result = calculate.division(result, Double.parseDouble(number));
        } else if (Pattern.matches("[^0-9]", splitWord)) {
//            exception 호출
            System.out.println("Exception");
        }
        return result;
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

//        calculator.sliceMathExpression("13+2-3");
        System.out.println( calculator.makeResult(calculator.sliceMathExpression("10-2*3")));

    }


}
