package calculator;

public class Calculator {

    public int calculator(String input) {

        validateInput(input);
        String[] str = input.split(" ");

        int result = Integer.parseInt(str[0]);
        for (int i = 0 ; i < str.length - 2 ; i += 2) {
            int nextInt = Integer.parseInt(str[i+2]);
            result = operate(result, str[i+1], nextInt);
        }

        return result;
    }

    public void validateInput(String input) {
        // 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public int operate(int num1, String sign, int num2) {
        if (sign.equals("+")) {
            return add(num1, num2);
        }
        if (sign.equals("-")) {
            return subtract(num1, num2);
        }
        if (sign.equals("*")) {
            return multiply(num1, num2);
        }
        if (sign.equals("/")) {
            return divide(num1, num2);
        }

        // 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
        throw new IllegalArgumentException();
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }
    public int subtract(int num1, int num2) {
        return num1 - num2;
    }
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }
    public int divide(int num1, int num2) {
        return num1 / num2;
    }
}
