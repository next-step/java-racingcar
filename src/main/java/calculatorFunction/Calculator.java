package calculatorFunction;

import java.util.ArrayList;

public class Calculator {

    private ArrayList<String> parsedValues;
    private double result;

    public Calculator(ArrayList<String> parsedValues) {
        this.parsedValues = parsedValues;
        this.result = Double.parseDouble(parsedValues.get(0));
    }

    public static void execute() {
        System.out.println("수식을 입력하시오: ");
        String expression = GetInput.inputString();
        if (expression.length() == 0) {
            throw new IllegalArgumentException("Error: need right expression");
        }
        ArrayList<String> parsedValues = GetInput.parse(expression);
        Calculator calculator = new Calculator(parsedValues);
        calculator.returnCalculatedValue();
    }

    public void returnCalculatedValue() {
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
    }
}
