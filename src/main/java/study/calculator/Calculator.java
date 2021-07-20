package study.calculator;

public class Calculator {

    public static int plus(int num1, int num2) {
        return num1 + num2;
    }

    public static int minus(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public static int divisionShare(int num1, int num2) {
        return num1 / num2;
    }

    public static int divisionRemainder(int num1, int num2) {
        return num1 % num2;
    }

    public static int getOperation(int num1, String operation, int num2) {

        int result = 0;

        switch (operation) {
            case "+":
                result = plus(num1, num2);
                break;
            case "-":
                result = minus(num1, num2);
                break;
            case "*":
                result = multiply(num1, num2);
                break;
            case "/":
                result = divisionShare(num1, num2);
                break;
            default:
                System.out.println("수식이 없습니다.");
                break;
        }

        return result;
    }
}
