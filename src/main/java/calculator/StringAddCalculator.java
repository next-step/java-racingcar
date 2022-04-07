package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.equals("")) {
            return 0;
        }
        String[] values = input.split(",|:");

        return sum(toIntArray(values));
    }

    private static int[] toIntArray(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }

        return numbers;
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for(int number : numbers) {
            result += number;
        }

        return result;
    }
}
