package step2;

import java.util.Arrays;
import java.util.Objects;

public class StringCalculator {

    public static final int DEFAULT_RESULT_VALUE = 0;

    public static int splitAndSum(String text) {
        if (!isValidText(text)) return DEFAULT_RESULT_VALUE;
        String[] split = TextSeparator.separate(text);
        PositiveNumberList positiveNumberList = new PositiveNumberList(split);
        return positiveNumberList.toIntegerList()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static boolean isValidText(String text) {
        return !(Objects.isNull(text) || text.isBlank() || text.isEmpty());
    }
}
