package study.utils;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    private static final String COMMA = ",";

    public static List<String> splitByComma(String givenValue) {
        String[] stringArray = givenValue.split(COMMA);
        return toArray(stringArray);
    }

    private static List<String> toArray(String[] stringArray) {
        return Arrays.asList(stringArray);
    }
}
