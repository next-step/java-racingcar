package caculator;

import java.util.Arrays;

public class StringAddCalculator {

    public static long add(final String value) {
        return Arrays.stream(StringSplitter.split(value))
                     .map(PositiveNumber::new)
                     .map(PositiveNumber::getValue)
                     .reduce(0L, Long::sum);
    }
}
