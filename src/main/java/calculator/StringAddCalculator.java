package calculator;

import java.util.List;

public class StringAddCalculator {
    private static final List<Spliter> SPLITERS =
            List.of(new CustomSpliter(), new DefaultSpliter());

    public static int splitAndSum(String text) {
        if (isNotValid(text)) {
            return 0;
        }

        return Operator.sum(split(text));
    }

    private static String[] split(String text) {
        return SPLITERS.stream()
                .filter(spliter -> spliter.isSupport(text))
                .findFirst()
                .map(spliter -> spliter.split(text))
                .orElse(new String[0]);
    }

    private static boolean isNotValid(String text) {
        return text == null || text.isEmpty();
    }
}
