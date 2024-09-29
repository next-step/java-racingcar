package calculator.splitter;

import java.util.List;

public abstract class Splitter {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\n";

    private Splitter() {}

    public static List<String> split(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX) && input.contains(CUSTOM_DELIMITER_SUFFIX)
                ? new CustomSplitter(input).split()
                : new DefaultSplitter(input).split();
    }
}
