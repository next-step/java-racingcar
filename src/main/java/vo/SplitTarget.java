package vo;

import java.util.Optional;

import utils.StringUtils;

public class SplitTarget {
    private final String value;

    private String delimiters = "[,:]";

    private SplitTarget(String value) {
        this.value = Optional.ofNullable(value)
            .filter(v -> !StringUtils.isNullOrEmpty(v))
            .map(this::extractDelimiters)
            .orElse("0");
    }

    private String extractDelimiters(String value) {
        if (value.startsWith("//") && value.contains("\n")) {
            delimiters = value.substring(2, value.indexOf("\n"));
            value = value.substring(value.indexOf("\n") + 1);
        }
        return value;
    }

    public static SplitTarget of(String value) {
        return new SplitTarget(value);
    }

    public SplitStrings split() {
        String[] split = value.split(delimiters);
        return SplitStrings.of(split);
    }
}
