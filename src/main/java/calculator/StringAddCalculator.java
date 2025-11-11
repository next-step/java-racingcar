package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }

        InputParser inputParser = new InputParser(input);
        ParsedInput parsedInput = inputParser.parse();

        return sum(toInts(split(parsedInput)));
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(ParsedInput parsedInput) {
        return parsedInput.getContent().split(parsedInput.getDelimiter());
    }

    private static int[] toInts(String[] inputs) {
        int[] numbers = new int[inputs.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = toInt(inputs[i]);
        }
        return numbers;
    }

    private static int toInt(String input) {
        int number = Integer.parseInt(input);

        if (number < 0) {
            throw new RuntimeException("음수가 포함되었습니다.");
        }
        return number;
    }

    private static int sum(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
