package study.step2;

public class StringCalculator {

    private String input;
    private int result;

    public int getResult() {
        return result;
    }

    public StringCalculator input(String input) {
        validate(input);
        return this;
    }

    private void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException(CalculatorError.INPUT_NULL);
        }

        if (input.isEmpty() || input.trim().isEmpty()) {
            throw new IllegalArgumentException(CalculatorError.INPUT_BLANK);
        }
        this.input = input;
    }

    public void calculate() {
        String[] str = input.split(" ");

        result = Integer.parseInt(str[0]);
        for (int index = 1; index < str.length - 1; index += 2) {
            result = Operator.execute(result, str[index], Integer.parseInt(str[index + 1]));
        }
    }
}
