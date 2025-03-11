package vo;

import java.util.Optional;

import utils.StringUtils;

public class SplitTarget {
    private final String value;

    private static final String DELIMITER_PREFIX = "//";
    private static final String DELIMITER_SUFFIX = "\n";
    private static final int DELIMITER_START_INDEX = 2;
    private static final String DEFAULT_VALUE = "0";

    private String delimiters = "[,:]";

    private SplitTarget(String value) {
        this.value = Optional.ofNullable(value)
            .filter(v -> !StringUtils.isNullOrEmpty(v))
            .map(this::configureInstance)
            .orElse(DEFAULT_VALUE);
    }

    private String configureInstance(String value) {
        if (hasCustomDelimiters(value)) {
            delimiters = value.substring(DELIMITER_START_INDEX, value.indexOf(DELIMITER_SUFFIX));
            value = value.substring(value.indexOf(DELIMITER_SUFFIX) + 1);
        }
        return value;
    }

    private static boolean hasCustomDelimiters(String value) {
        return value.startsWith(DELIMITER_PREFIX) && value.contains(DELIMITER_SUFFIX);
    }

    public static SplitTarget of(String value) {
        return new SplitTarget(value);
    }

    public SplitStrings split() {
        String[] split = value.split(delimiters);
        return SplitStrings.of(split);
    }
}
