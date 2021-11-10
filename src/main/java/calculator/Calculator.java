package calculator;

public class Calculator {
    public static int calculate(String input) {
        checkNullOrBlank(input);
        String[] values = input.split(" ");
        MyNumber firstNumber = new MyNumber(values[0]);
        String operator = values[1];
        MyNumber secondNumber = new MyNumber(values[2]);

        return calculate(firstNumber, operator, secondNumber).getNumber();
    }

    private static MyNumber calculate(MyNumber first, String operator, MyNumber second) {
        if (operator.equals("+")) {
            return first.plus(second);
        }
        if (operator.equals("-")) {
            return first.minus(second);
        }
        if (operator.equals("*")) {
            return first.multiply(second);
        }
        if (operator.equals("/")) {
            return first.divide(second);
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }

    private static void checkNullOrBlank(String input) {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자입니다.");
        }
    }
}
