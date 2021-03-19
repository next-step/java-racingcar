package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    private static final int ZERO = 0;
    private static final String COMMA = ",";

    private StringUtils() {
    }

    public static boolean isNullAndBlank(String sentence) {
        if (isNull(sentence)) return true;
        if (isBlank(sentence)) return true;
        return false;
    }

    private static boolean isNull(String sentence) {
        return sentence == null;
    }

    private static boolean isBlank(String sentence) {
        return sentence.trim().length() == ZERO;
    }

    public static List<String> splitByCommaToList(String sentence) {
        return Arrays.stream(splitByComma(sentence)).collect(Collectors.toList());
    }

    public static String[] splitByComma(String sentence) {
        return sentence.split(COMMA);
    }

}
