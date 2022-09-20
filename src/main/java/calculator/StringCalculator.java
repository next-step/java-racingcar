package calculator;

import java.util.Arrays;

import static calculator.Separator.separate;
import static util.StringUtils.containsNegativeNumber;
import static util.StringUtils.isNullOrEmpty;


public class StringCalculator {

    private StringCalculator() {}

    public static int calculate(String expression) {
        if (isNullOrEmpty(expression)) return 0;
        if (containsNegativeNumber(expression)) throw new RuntimeException("입력 값에는 숫자를 제외한 문자는 포함될 수 없습니다.");

        String[] numbers = separate(expression);

        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }

}
