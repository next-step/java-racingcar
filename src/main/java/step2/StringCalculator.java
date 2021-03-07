package step2;

public class StringCalculator {

    public static long calculate(String input) {
        validate(input);
        String[] arr = input.split(" ");
        return getResult(arr);
    }

    private static void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException(CalculatorException.INPUT_NULL);
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException(CalculatorException.INPUT_BLANK);
        }
    }

    private static long getResult(String[] arr) {
        long result = Long.parseLong(arr[0]);
        for (int i = 1; i < arr.length; i += 2) {
            Operator operator = Operator.findOperator(arr[i]);
            result = operator.calculate(result, Long.parseLong(arr[i + 1]));
        }
        return result;
    }
}
