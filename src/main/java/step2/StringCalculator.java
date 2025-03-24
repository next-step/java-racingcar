package step2;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final Pattern BASIC_PATTERN = Pattern.compile(",|:");

    public static int splitAndSum(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        DelimiterReader reader = new DelimiterReader();

        if (reader.hasCustomDelimiter(text)) {
            return sum(reader.extractAndSplit(text));
        }

        return sum(text.split(BASIC_PATTERN.pattern()));
    }

    private static Integer sum(String[] numbers) {
        return Arrays.stream(numbers)
                .map(it -> {
                            int num = Integer.parseInt(it);
                            if (num < 0) {
                                throw new RuntimeException("숫자는 음수일 수 없습니다");
                            }
                            return num;
                        }
                ).reduce(0, Integer::sum);
    }
}
