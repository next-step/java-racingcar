package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int splitAndSum(String input) {
        String delimiter = "[,:]";

        input = check(input);

        if (input.startsWith("//")) {
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (m.find()) {
                delimiter = m.group(1);
                input = m.group(2);
            }
        }

        return sum(input.split(delimiter));
    }

    public static int sum(String[] sentences) {
        return Arrays.stream(sentences)
                .mapToInt(Integer::parseInt)
                .peek(n -> {
                    if (n < 0) {
                        throw new RuntimeException("정수만 입력해주세요.");
                    }
                })
                .sum();
    }

    public static String check(String sentence) {
        if (sentence == null || sentence.isEmpty()) return "0";

        return sentence;
    }
}
