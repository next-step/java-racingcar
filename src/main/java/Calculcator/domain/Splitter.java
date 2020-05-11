package Calculcator.domain;

import java.util.Arrays;
import java.util.List;

public class Splitter {
    private static final String DELIMETER = " ";

    private Splitter() {
    }

    public static List<String> split(String expression) {
        return Arrays.asList(expression.split(DELIMETER));
    }
}
