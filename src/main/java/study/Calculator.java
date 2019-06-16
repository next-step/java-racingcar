package study;

import java.util.regex.Pattern;

public class Calculator {


    public int computation(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;

            case "*":
                return num1 * num2;

            case "/":
                return num1 / num2;
        }

        return 0;
    }

    public void nullAndEmptyValue(String number) {
        if (number == null || number.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    public String checkPolicyOperator(String operator) {

        switch (operator) {
            case "+":
            case "-":
            case "*":
            case "/":
                return operator;
        }

        throw new IllegalArgumentException();
    }

    public String[] getSplitFormula(String formula) {
        return formula.split(" ");
    }

    public boolean isNumber(String value){
        return Pattern.matches("^[0-9]*$", value);
    }
}
