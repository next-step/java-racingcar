package lotto;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.Arrays;

public class StringAddCalculator {
    private static final String[] DEFAULT_SPLITTER = {",", ":"};

    public static int splitAndSum(String text) {
        Text textObj = null;
        try {
            textObj = new Text(text, DEFAULT_SPLITTER);
        } catch (IllegalArgumentException e) {
            return 0;
        }
        return textObj.getValues().getValues().stream()
                .mapToInt(Integer::parseInt)
                .reduce(0, Integer::sum);
    }

}
