package study;

public class Calculator {

    public static final String DELIMITER = " ";

    public static int calculate(String input) {
        validate(input);

        String[] values = input.split(DELIMITER);

        InputNumber first = new InputNumber(values[0]);

        for (int i = 1; i < values.length; i+=2) {
            String operator = values[i];
            InputNumber second = new InputNumber(values[i+1]);


            first = calculate(first, second, operator);
        }

        return first.getInputNumber();
    }

    private static void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null이나 빈 공백 문자입니다.");
        }
    }

    private static InputNumber calculate(InputNumber first, InputNumber second, String operator) {
        return Operator.calculate(first, second, operator);
    }
}
