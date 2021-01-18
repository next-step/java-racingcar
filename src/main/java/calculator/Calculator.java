package calculator;

import java.util.ArrayDeque;

public class Calculator {
    public Double calculate(ArrayDeque<String> expression) {
        Double result = Double.parseDouble(expression.pop());
        while(!expression.isEmpty()){
            String operator = expression.pop();
            Double number = Double.parseDouble(expression.pop());
            try {
                result = selectOperator(operator, result, number);
            } catch (ArithmeticException e){
                e.printStackTrace();
                return 0.0;
            }
        }
        return result;
    }

    public Double selectOperator (String operator, Double num1, Double num2) throws ArithmeticException{
        double result = 0;
        switch (operator) {
            case "+":
                result = add(num1, num2);
                break;
            case "-":
                result = sub(num1, num2);
                break;
            case "*":
                result = mul(num1, num2);
                break;
            case "/":
                result = div(num1, num2);
                break;
        }
        return result;
    }

    public Double add(Double num1, Double num2) {
        return num1 + num2;
    }

    public Double sub(Double num1, Double num2) {
        return num1 - num2;
    }

    public Double mul(Double num1, Double num2) {
        return num1 * num2;
    }

    public Double div(Double num1, Double num2) throws ArithmeticException {
        Double divResult = num1 / num2;
        if (Double.isInfinite(divResult) || Double.isNaN(divResult)){
            throw new ArithmeticException("0 또는 0.0 으로 나눌 수 없습니다.");
        }
        return num1 / num2;
    }


}
