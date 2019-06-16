package study;

public class Calculator {
    public int Addition(int num1, int num2) {
        return num1 + num2;
    }

    public int subtraction(int num1, int num2) {
        return num1 - num2;
    }

    public int multiplication(int num1, int num2) {
        return num1 * num2;
    }

    public int division(int num1, int num2) {
        return num1 / num2;
    }

    public int nullAndEmptyValue(String number) {
        if (number == null || number == " ") {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(number);
    }

    public String checkPolicyOperator(String operator) {

        switch (operator){
            case "+" :
            case "-" :
            case "*" :
            case "/" :
                return operator;
        }

        throw new IllegalArgumentException();
    }

}
