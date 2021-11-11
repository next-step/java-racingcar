package calculator;

public class Calculator {

    public static int calculate(String text) {
        validText(text);

        String[] value = text.split(" ");
        Operand result = new Operand(value[0]);

        for (int i = 1; i < value.length - 1; i += 2) {
            Operator operator = Operator.of(value[i]);
            Operand second = new Operand(value[i + 1]);

            result = operator.operate(result, second);
        }

        return result.getValue();
    }

    private static void validText(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자입니다");
        }
    }

}
