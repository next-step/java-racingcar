package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }

        return sum(toInt(split(text)));
    }

    private static int sum(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    private static String[] split(String text) {

        if (text.contains(",")) {
            return text.split(",");
        }
        return new String[]{text};
    }

    private static int[] toInt(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }

        return numbers;
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }
}
