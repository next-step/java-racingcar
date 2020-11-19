package racing.utils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtils {
    private StringUtils() {
    }

    public static String repeat(String word, int count) {
        return Stream.generate(() -> word)
                .limit(count)
                .collect(Collectors.joining());
    }
}
