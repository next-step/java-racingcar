package study;

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

    public int nullAndEmptyValue(String number) {
        if (number == null || number.equals(" ")) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(number);
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
}
