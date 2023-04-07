package calculator;

public final class StringCalculator {

    private static final int DEFAULT_VALUE = 0;

    private StringCalculator() {
        throw new IllegalCallerException("객체 생성이 불필요합니다.");
    }

    public static int calculate(String text) {
        if (isEmpty(text)) {
            return DEFAULT_VALUE;
        }
        int[] numbers = StringToken.from(text)
                                   .toIntArray();
        return sum(numbers);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
