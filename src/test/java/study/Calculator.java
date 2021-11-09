package study;

public class Calculator {

    public static int calculate(String input) {
        validate(input);

        String[] values = input.split(" ");
        InputNumber first = new InputNumber(values[0]);
        InputNumber second = new InputNumber(values[2]);
        String operator = values[1];

        return calculate(first, second, operator).getInputNumber();
    }

    private static void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null이나 빈 공백 문자입니다.");
        }
    }

    private static InputNumber calculate(InputNumber first, InputNumber second, String operator) {
        if ("+".equals(operator)) {
            return first.add(second);
        }
        if ("-".equals(operator)) {
            return first.subtract(second);
        }
        if ("*".equals(operator)) {
            return first.multiply(second);
        }
        if ("/".equals(operator)) {
            return first.divide(second);

        }
        throw new IllegalArgumentException("사칙 연산 기호가 아닙니다.");
    }
}
