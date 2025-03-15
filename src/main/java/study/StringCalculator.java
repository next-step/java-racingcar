package study;

public class StringCalculator {

    public static final String DELIMETER = ",";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        String[] values = text.split(DELIMETER);
        int[] numbers = toInts(values);

        return sum(numbers);
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            numbers[i] = toInt(values[i]);
        }

        return numbers;
    }

    private static int sum(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }
}
