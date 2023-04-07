package calculator;

public final class StringCalculator {

    private StringCalculator() {
        throw new IllegalCallerException("객체 생성이 불필요합니다.");
    }

    public static int calculate(String text) {
        int[] numbers = StringToken.from(text)
                                   .toIntArray();
        return sum(numbers);
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
