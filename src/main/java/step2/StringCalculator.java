package step2;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = "[,:]";

    public static long calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0L;
        }
        return sum(parseLong(split(input)));
    }

    private static String[] split(String input) {
        return input.split(DEFAULT_DELIMITER);
    }

    private static long[] parseLong(String[] numbers) {
        long[] newNumbers = new long[numbers.length];
        try {
            for (int i = 0; i < numbers.length; i++) {
                newNumbers[i] = Long.parseLong(numbers[i]);
                if(newNumbers[i] < 0) {
                    throw new RuntimeException("음수가 입력되었습니다.");
                }
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아니거나 Long 범위를 초과한 수가 입력되었습니다.");
        }
        return newNumbers;
    }
    private static long sum(long[] numbers) {
        long sum = 0;
        for (long number : numbers) {
            sum += number;
        }
        return sum;
    }
}
