package carracing.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtil {
    public static final String DELIMETER = ",";
    public static final int WORD_LENGTH = 5;

    public static List<String> split(final String inputString) {
        return Arrays.asList(inputString.split(DELIMETER));
    }

    public static Boolean checkWordLength(String rightWord) {
        return rightWord.length() <= WORD_LENGTH;
    }
}
