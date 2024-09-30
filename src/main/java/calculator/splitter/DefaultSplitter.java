package calculator.splitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DefaultSplitter {

    public static final String DEFAULT_DELIMITER_REGEX = ",|:";

    private final String input;

    protected DefaultSplitter(String input) {
        this.input = input;
    }

    List<String> split() {
        List<String> split = Arrays.asList(input.split(DEFAULT_DELIMITER_REGEX));

        return filterEmptyString(split);
    }

    private static List<String> filterEmptyString(List<String> split) {
        List<String> result = new ArrayList<>();

        for (String number : split) {
            if (!number.isEmpty()) {
                result.add(number);
            }
        }

        return result;
    }
}
