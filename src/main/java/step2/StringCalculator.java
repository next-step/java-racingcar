package step2;

import java.util.Arrays;

public class StringCalculator {

    public static int splitAndSum(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        DelimiterReader reader = new DelimiterReader();

        if (reader.hasCustomDelimiter(s)) {
            return sum(reader.extractAndSplit(s));
        }

        return sum(s.split(",|:"));
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
