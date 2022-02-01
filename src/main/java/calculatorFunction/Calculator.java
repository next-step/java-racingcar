package calculatorFunction;

import java.util.ArrayList;

public class Calculator {

    private ArrayList<String> parsedValues = null;

    public Calculator(ArrayList<String> parsedValues) {
        this.parsedValues = parsedValues;
    }

    public static void execute() {
        System.out.println("수식을 입력하시오: ");
        String str = GetInput.inputString();
        if (str.length() == 0) {
            throw new IllegalArgumentException("Error: need right expression");
        }
        ArrayList<String> parsedValues = GetInput.parsing(str);
        Calculator calculator = new Calculator(parsedValues);
        calculator.returnCalculatedValue();
    }

    public void returnCalculatedValue() {
        for (int i = 0; i < (parsedValues.size() + 1) / 2; i++) {
            if (determineCalculatedValueValid(i)) {
                return;
            }
            parseOperation(i * 2);
        }
    }

    public boolean determineCalculatedValueValid(int i) {
        if (i * 2 == parsedValues.size() - 1) {
            System.out.println(
                "정답: " + Double.parseDouble(parsedValues.get(parsedValues.size() - 1)));
            return true;
        }

        return false;
    }

    public void parseOperation(int start) {
        Operations operations = new Operations();
        String operator = parsedValues.get(start + 1);
        operations.firstOperand = Double.parseDouble(parsedValues.get(start));
        operations.secondOperand = Double.parseDouble(parsedValues.get(start + 2));

        double result = 0;
        if (operator.equals("+")) {
            result = operations.add();
        } else if (operator.equals("-")) {
            result = operations.sub();
        } else if (operator.equals("*")) {
            result = operations.mul();
        } else if (operator.equals("/")) {
            if (operations.secondOperand == 0) {
                throw new IllegalArgumentException("Error: division by zero");
            } else {
                result = operations.div();
            }
        } else {
            throw new IllegalArgumentException("Error: need right operator");
        }

        parsedValues.set(start + 2, String.valueOf(result));
    }
}
