package calculatorFunction;

import java.util.List;
import java.util.ArrayList;

public class Calculator {

    public static void execute() {
        System.out.println("수식을 입력하시오: ");
        String str = GetInput.inputString();
        if (str.length() == 0) {
            throw new IllegalArgumentException("Error: need right expression");
        }
        ArrayList<String> stringArray = GetInput.parsing(str);
        Calculator.returnCalculatedValue(stringArray);
    }

    public static void returnCalculatedValue(List<String> stringArray) {
        for (int i = 0; i < (stringArray.size() + 1) / 2; i++) {
            if (determineCalculatedValueValid(stringArray, i)) {
                return;
            }
            parseOperation(stringArray, i * 2);
        }
    }

    public static boolean determineCalculatedValueValid(List<String> stringArray, int i) {
        if (i * 2 == stringArray.size() - 1) {
            System.out.println(
                "정답: " + Double.parseDouble(stringArray.get(stringArray.size() - 1)));
            return true;
        }

        return false;
    }

    public static void parseOperation(List<String> stringArray, int start) {
        Operations operations = new Operations();
        String operator = stringArray.get(start + 1);
        operations.firstOperand = Double.parseDouble(stringArray.get(start));
        operations.secondOperand = Double.parseDouble(stringArray.get(start + 2));

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

        stringArray.set(start + 2, String.valueOf(result));
    }
}
