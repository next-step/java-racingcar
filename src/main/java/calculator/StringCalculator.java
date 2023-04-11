package calculator;

import java.util.List;

public final class StringCalculator {

    private StringCalculator() {
        throw new IllegalCallerException("객체 생성이 불필요합니다.");
    }

    public static int calculate(String text) {
        List<Integer> numbers = StringToken.from(text)
                                           .toIntArray();
        return sum(numbers);
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
