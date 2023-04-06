package calculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringAddCalculator {
    private static final CustomSpliter CUSTOM_SPLITER = new CustomSpliter();
    private static final DefaultSpliter DEFAULT_SPLITER = new DefaultSpliter();

    public static int splitAndSum(String text) {
        if (isNotValid(text)) {
            return 0;
        }

        return Operator.sum(split(text));
    }

    private static String[] split(String text) {
        return Stream.concat(
                        Arrays.stream(DEFAULT_SPLITER.split(text)),
                        Arrays.stream(CUSTOM_SPLITER.split(text)))
                .toArray(String[]::new);
    }

    private static boolean isNotValid(String text) {
        return text == null || text.isEmpty();
    }
}
