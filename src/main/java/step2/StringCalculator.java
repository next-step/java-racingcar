package step2;

import java.util.Arrays;
import java.util.Objects;

public class StringCalculator {
    public static int splitAndSum(String text) {
        if (validText(text)) return 0;

        String[] split = TextSeparator.separate(text);

        return Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static boolean validText(String text) {
        return Objects.isNull(text) || text.isBlank() || text.isEmpty();
    }
}
