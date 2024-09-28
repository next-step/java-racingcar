package calculator;

public class StringAdditionCalculator {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\n";

    public static int calculate(String input) {
        if (isInputEmpty(input)) return 0;
        int[] numbers = extractNumbers(input);
        return sum(numbers);
    }

    private static boolean isInputEmpty(String input) {
        return (input == null || input.isEmpty());
    }

    private static int[] extractNumbers(String input) {
        String delimiter = DEFAULT_DELIMITER;
        if (isCustomDelimiterUsed(input)) {
            delimiter = extractCustomDelimiter(input);
            input = removeCustomDelimiterPart(input);
        }
        return convertStringArrayToIntArray(input.split(delimiter));
    }

    private static boolean isCustomDelimiterUsed(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX) && input.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    private static String extractCustomDelimiter(String input) {
        int start = input.indexOf("//") + 2;
        int end = input.indexOf("\n");
        return input.substring(start, end);
    }

    private static String removeCustomDelimiterPart(String input) {
        int end = input.indexOf("\n");
        return input.substring(end + 1);
    }

    private static int[] convertStringArrayToIntArray(String[] stringArray) {
        int[] numbers = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            numbers[i] = Integer.parseInt(stringArray[i]);
            if (numbers[i] < 0) throw new RuntimeException("음수는 허용하지 않습니다");
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
