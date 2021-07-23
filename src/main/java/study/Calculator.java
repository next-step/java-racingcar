package study;

public class Calculator {

    public static int calculate(String data) {

        String[] dataArray = data.split(" ");

        //TODO data 연산이 길어질 경우 고려
        int firstOperand = Integer.parseInt(dataArray[0]);
        String operator = dataArray[1];
        int secondOperand = Integer.parseInt(dataArray[2]);

        int result = 0;

        if ("+".equals(operator)) {
            result = plus(firstOperand, secondOperand);
        }
        if ("-".equals(operator)) {
            result = minus(firstOperand, secondOperand);
        }
        if ("*".equals(operator)) {
            result = multiply(firstOperand, secondOperand);
        }

        return result;
    }

    static int plus(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }

    static int minus(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }

    static int multiply(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }
}
