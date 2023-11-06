package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {
    public static List<String> split(String text, String delimiter) {
        String[] stringArray = text.split(delimiter);
        return Arrays.stream(stringArray).collect(Collectors.toList());
    }
}
