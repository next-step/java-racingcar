package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<String> numbers;

    private Numbers(String[] numbers) {
        List<String> result = new ArrayList<>();
        for (String number : numbers) {
            validateInput(number);
            result.add(number);
        }
        this.numbers = result;
    }

    public static Numbers of(String[] numbers) {
        return new Numbers(numbers);
    }

    public int sumAll() {
        int result = 0;
        for (String number : this.numbers) {
            result += Integer.parseInt(number);
            validateOverflow(result);
        }

        return result;
    }

    private static void validateOverflow(int result) {
        if (result < 0) {
            throw new RuntimeException("계산 결과가 정수 범위를 벗어났습니다.");
        }
    }

    private static void validateInput(String value) {
        int result;
        try {
            result = toInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닙니다.");
        }

        if (result < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    private static int toInt(String number) {
        return Integer.parseInt(number);
    }
}
