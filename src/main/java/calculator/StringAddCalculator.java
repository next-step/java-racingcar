package calculator;

public class StringAddCalculator {

    public static final int DEFAULT_RETURN_VALUE = 0;

    public static int splitAndSum(String text) {
        Input input = new Input(text);

        if (input.isEmptyOrNull()) {
            return DEFAULT_RETURN_VALUE;
        }

        return sum(input);
    }

    private static int sum(Input input) {
        return input.toNumbers().stream()
                .mapToInt(number -> number)
                .sum();
    }

}
