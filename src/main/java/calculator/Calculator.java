package calculator;

import calculator.exception.InvalidOperatorException;
import calculator.exception.InvalidValueException;

import java.util.Scanner;

public class Calculator {

    Operator operator = new Operator();
    Util util = new Util();


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            throw new InvalidValueException();
        }
        String inputValue = scanner.nextLine();
        scanner.close();

        return inputValue;
    }

    public int calculate(String input) {
        String[] values = util.splitString(input);

        int leftNum = Integer.parseInt(values[0]);
        String strOperator = null;

        for (int i = 1; i< values.length; i++) {
            util.checkInvalidValue(values[i]);

            if (util.checkIsOddNumber(i)) {
                util.checkInvalidOperator(values[i]);
                strOperator = values[i];
            } else {
                int intValue = Integer.parseInt(values[i]);
                leftNum = operate(leftNum, strOperator, intValue);
            }
        }

        return leftNum;
    }

    public int operate(int leftNum, String strOperator, int rightNum) {
        if (strOperator == null) {
            throw new InvalidOperatorException();
        }

        if (strOperator.equals("+")) {
            return operator.add(leftNum, rightNum);
        }

        if (strOperator.equals("-")) {
            return operator.subtract(leftNum, rightNum);
        }

        if (strOperator.equals("*")) {
            return operator.multiply(leftNum, rightNum);
        }

        if (strOperator.equals("/")) {
            return operator.divide(leftNum, rightNum);
        }
        return 0;
    }
}




