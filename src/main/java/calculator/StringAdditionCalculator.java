package calculator;

public class StringAdditionCalculator {

    private static final String DELIMETER = "[,:]";

    public static int calculate(String input) {
        if (input == null || input.isBlank()) return 0;
        int[] numbers = extractNumbers(input);
        return sum(numbers);
    }

    private static int[] extractNumbers(String input) {
        String[] inputArray = input.split(DELIMETER);
        int[] numbers = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            numbers[i] = Integer.parseInt(inputArray[i]);
        }
        return numbers;
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
