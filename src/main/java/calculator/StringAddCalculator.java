package calculator;

public class StringAddCalculator {
    public static String SEPARATOR = ",|:";
    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toInts(split(text)));
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int[] toInts(String[] numbersStr) {
        int[] numbers = new int[numbersStr.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = positive(numbersStr[i]);
        }
        return numbers;
    }

    private static int positive(String numbersStr) {
        int number = Integer.parseInt(numbersStr);
        if (number < 0) {
            throw new RuntimeException("음수 값이 들어올 수 없습니다.");
        }
        return number;
    }

    private static String[] split(String text) {
        return text.split(SEPARATOR);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }
}
