package stringcalculator;

public class StringCalculator {
    public int calculateAll(String input) {
        validate(input);

        String[] args = input.split(" ");

        int result = Integer.parseInt(args[0]);
        for (int i = 1; i < args.length; i += 2) {
            Operator operator = OperatorFactory.create(args[i]);
            result = operator.calculate(result, Integer.parseInt(args[i + 1]));
        }

        return result;
    }

    private void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다!");
        }
    }
}
