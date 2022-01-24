package calculator;

import calculator.domain.calculator.Addition;
import calculator.domain.calculator.Division;
import calculator.domain.calculator.Multiplication;
import calculator.domain.calculator.Subtraction;
import calculator.domain.calculator.CalculatorFactory;
import calculator.domain.calculator.CalculatorStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

    CalculatorFactory calculatorFactory;
    Map<String, Object> map = new HashMap<>();
    static String ADD = "+";
    static String SUB = "-";
    static String MUL = "*";
    static String DIV = "/";

    public Calculator() {
        calculatorFactory = new CalculatorFactory();

        map.put(ADD, new Addition());
        map.put(SUB, new Subtraction());
        map.put(MUL, new Multiplication());
        map.put(DIV, new Division());
    }

    private double doBinaryOperation(double num1, double num2, String ope) {
        return calculatorFactory.get((CalculatorStrategy) map.get(ope), num1, num2);
    }

    public double doMultipleOperation(Number numbers, Symbol symbols) {
        double result = numbers.remove(0);
        for (int i = 0; i < numbers.size(); i++) {
            result = doBinaryOperation(result, numbers.get(i), symbols.get(i));
        }
        return result;
    }
}
