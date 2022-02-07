package calculatorFunction;

import java.util.ArrayList;

public class Calculator {

    private ArrayList<String> parsedValues;
    private double result;

    public Calculator(ArrayList<String> parsedValues) {
        this.parsedValues = parsedValues;
        this.result = Double.parseDouble(parsedValues.get(0));
    }

    public void returnCalculatedValue() {

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class Calculator {

    private ArrayList<String> parsedValues = null;
    private HashMap<String, Method> operatorMap = new HashMap<>();

    public Calculator(ArrayList<String> parsedValues) {
        this.parsedValues = parsedValues;
    }

    public static void execute()
        throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        System.out.println("수식을 입력하시오: ");
        String expression = GetInput.inputString();
        if (expression.length() == 0) {
            throw new IllegalArgumentException("Error: need right expression");
        }
        ArrayList<String> parsedValues = GetInput.parse(expression);
        Calculator calculator = new Calculator(parsedValues);
        calculator.setOperatorMap();
        calculator.returnCalculatedValue();
    }

    public void returnCalculatedValue()
        throws InvocationTargetException, IllegalAccessException {
        int parsedValuesSize = parsedValues.size();
        for (int i = 0; i < (parsedValuesSize + 1) / 2; i++) {
            if (determineCalculatedValueValid(i)) {
                return;
            }
            parseOperation(i * 2);
        }
    }

    public boolean determineCalculatedValueValid(int i) {
        int parsedValuesSize = parsedValues.size();
        if (i * 2 == parsedValuesSize - 1) {
            System.out.println("정답: " + Double.parseDouble(parsedValues.get(parsedValues.size() - 1)));

    public void setOperatorMap() throws NoSuchMethodException {
        operatorMap.put("+", Operations.class.getMethod("add"));
        operatorMap.put("-", Operations.class.getMethod("sub"));
        operatorMap.put("*", Operations.class.getMethod("mul"));
        operatorMap.put("/", Operations.class.getMethod("div"));
    }

    public boolean determineCalculatedValueValid(int i) {
        int parsedValuesSize = parsedValues.size();
        if (i * 2 == parsedValuesSize - 1) {
            System.out.println(
                "정답: " + Double.parseDouble(parsedValues.get(parsedValues.size() - 1)));
            return true;
        }

        return false;
    }

    public void parseOperation(int parseIdx) {
        String operator = parsedValues.get(parseIdx + 1);
        double operand = Double.parseDouble(parsedValues.get(parseIdx + 2));
        this.result = calculate(operator, result, operand);
        parsedValues.set(parseIdx + 2, String.valueOf(result));
    }

    private static double calculate(String operator, double result, double operand) {
        return Operators.calculate(operator, result, operand);

    public void parseOperation(int parseIdx)
        throws InvocationTargetException, IllegalAccessException {
        String operator = parsedValues.get(parseIdx + 1);
        Operations.firstOperand = Double.parseDouble(parsedValues.get(parseIdx));
        Operations.secondOperand = Double.parseDouble(parsedValues.get(parseIdx + 2));

        if (!operatorMap.containsKey(operator)) {
            throw new IllegalArgumentException("Error: need right operator");
        }

        double result = (double) operatorMap.get(operator).invoke(null);

        parsedValues.set(parseIdx + 2, String.valueOf(result));
    }
}
