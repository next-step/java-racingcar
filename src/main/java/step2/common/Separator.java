package step2.common;

public enum Separator {

    REGULAR_SEPARATOR(",|:"),
    CUSTOM_SEPARATOR("\\/\\/(.)(.*)\\n"),
    NEGATIVE_NUMERIC_SEPARATOR("(-[0-9])");

    private final String regexp;

    Separator(String regexp) {
        this.regexp = regexp;
    }

    public String getRegexp() {
        return regexp;
    }
}
