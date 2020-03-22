package calculator;

public class StringCalculator {

    public int calculate(String input) {
        checkInput(input);

        input = input.trim();

        String[] expression = input.split(" ");
        int acc = Integer.parseInt(expression[0]);

        for (int i = 1 ; i < expression.length ; i += 2) {
            acc = Operator.of(expression[i]).operate(acc, Integer.parseInt(expression[i + 1]));
        }

        return acc;
    }

    private void checkInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("계산기의 입력은 null 일 수 없다.");
        }
    }
}
