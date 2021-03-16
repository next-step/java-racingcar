package step2;

public class StringCalculator {

    public static long calculate(String input) {
        validate(input);
        String[] inputs = input.split(" ");
        return getResult(inputs);
    }

    private static void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException(CalculatorMessage.INPUT_NULL);
        }
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(CalculatorMessage.INPUT_BLANK);
        }
    }

    private static long getResult(String[] inputs) {
        long result = Long.parseLong(inputs[0]);
        for (int i = 1; i < inputs.length; i += 2) {
            Operator operator = Operator.findOperator(inputs[i]);
            result = operator.calculate(result, Long.parseLong(inputs[i + 1]));
        }
        return result;
    }
}
