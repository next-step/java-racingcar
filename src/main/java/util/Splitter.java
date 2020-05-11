package util;


import java.util.Arrays;
import java.util.List;

public class Splitter {

    private static final String EXPRESSION_DELIMITER = " ";

    private Splitter() {
    }

    public static List<String> split(String input) {
        return Arrays.asList(input.split(EXPRESSION_DELIMITER));
    }
}
