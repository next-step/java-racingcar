package racing.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {

    public static List<String> tokenize(String s, String delimiter) {

        return Arrays.stream(s.split(delimiter))
                .collect(Collectors.toList());
    }
}
