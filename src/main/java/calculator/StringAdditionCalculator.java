package calculator;

public class StringAdditionCalculator {

    private static final String DELIMITER = "[,:]";

    public static int calculate(String input) {
        if (isInputEmpty(input)) return 0;
        int[] numbers = extractNumbers(input);
        return sum(numbers);
    }

    private static boolean isInputEmpty(String input) {
        return (input == null || input.isBlank());
    }

    private static int[] extractNumbers(String input) {
        String delimiter = DELIMITER;
        if (input.startsWith("//")) {
            int start = input.indexOf("//") + 2;
            int end = input.indexOf("\n");

            if (end != -1) {
                delimiter = input.substring(start, end);
                input = input.substring(end + 1);
                System.out.println(input);
            }
        }
        String[] inputArray = input.split(delimiter);
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
