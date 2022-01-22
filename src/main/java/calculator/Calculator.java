package calculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    public Calculator(){
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("+", );
    }

    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double sub(double num1, double num2) {
        return num1 - num2;
    }

    public double mul(double num1, double num2) {
        return num1 * num2;
    }

    public double div(double num1, double num2) {
        return num1 / num2;
    }

    public double doBinaryOperation(double num1, double num2, String ope) {
        switch (ope) {
            case "+":
                return add(num1, num2);
            case "-":
                return sub(num1, num2);
            case "*":
                return mul(num1, num2);
            case "/":
                return div(num1, num2);
        }
        return 0;
    }

    public double doMultipleOperation(List<Integer> numbers, List<String> operator){
        double result = numbers.remove(0);
        for (int i=0; i < numbers.size(); i++){
            result = doBinaryOperation(result, (double) numbers.get(i), operator.get(i));
        }
        return result;
    }
}
