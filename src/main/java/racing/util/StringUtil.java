package racing.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {

    private StringUtil() {}

    public static List<String> split(String s, String delimiter) {

        return Arrays.stream(s.split(delimiter))
                .filter(result -> !result.isEmpty())
                .collect(Collectors.toList());
    }
}
