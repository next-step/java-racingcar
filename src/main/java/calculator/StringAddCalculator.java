package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }
        ParsedInput parsedInput = new InputParser(input).parse();
        Numbers numbers = new Numbers(parsedInput.split());
        return numbers.sum();
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }
}
