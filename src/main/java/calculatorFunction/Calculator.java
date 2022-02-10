package calculatorFunction;

import java.util.ArrayList;

public class Calculator {

    private final ArrayList<String> parsedValues;
    private double result;

    public Calculator(ArrayList<String> parsedValues) {
        this.parsedValues = parsedValues;
        this.result = Double.parseDouble(parsedValues.get(0));
    }

    public void getAnswer() {
        int parsedValuesSize = parsedValues.size();
        int i = 0;
        while (i * 2 != parsedValuesSize - 1) {
            parseOperation(i * 2);
            i += 1;
        }
        System.out.println("정답: " + Double.parseDouble(parsedValues.get(parsedValues.size() - 1)));
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
