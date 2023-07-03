package caculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public final class Calculator {

    public static final Pattern NUMBER_PATTERN = Pattern.compile("(^[0-9]*$)");

    private Calculator() {
    }

    public static int sum(String text) {
        return Arrays.stream(text.split(",|:"))
                     .mapToInt(Integer::parseInt)
                     .reduce(Integer::sum)
                     .orElseThrow(RuntimeException::new);
    }

}
