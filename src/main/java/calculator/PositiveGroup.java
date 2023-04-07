package calculator;

import java.util.ArrayList;
import java.util.List;

public class PositiveGroup {

    public static final int DEFAULT_SUM_VALUE = 0;
    private final List<Integer> numbers;

    private PositiveGroup(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getSum() {
        int sum = DEFAULT_SUM_VALUE;

        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }

    public static PositiveGroup create(String[] stringNumbers) {
        List<Integer> numbers = new ArrayList<>();

        for (String stringNumber : stringNumbers) {
            int convertedNumber = convertStringToNumber(stringNumber);
            if (convertedNumber < 0) {
                throw new RuntimeException("음수는 입력할 수 없습니다.");
            }

            numbers.add(convertedNumber);
        }

        return new PositiveGroup(numbers);
    }

    private static int convertStringToNumber(String stringNumber) throws RuntimeException {
        try {
            return Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값은 입력할 수 없습니다.");
        }
    }
}
