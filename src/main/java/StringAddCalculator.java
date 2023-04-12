import java.util.Arrays;
import java.util.Objects;

public class StringAddCalculator {
    private static final int ZERO = 0;

    public static int splitAndSum(String input) {
        if (isInputNullOrEmptyString(input)) {
            return ZERO;
        }
        String[] tokens = StringSeparator.splitStringByDelimiters(input);
        return Arrays.stream(tokens)
                     .map(s -> {
                         Integer i = Integer.parseInt(s);
                         if (i < 0) {
                             throw new RuntimeException("음수는 계산할 수 없습니다.");
                         }
                         return i;
                     })
                     .mapToInt(Integer::intValue)
                     .sum();
    }

    private static boolean isInputNullOrEmptyString(String input) {
        return Objects.isNull(input) || input.isEmpty();
    }

}
