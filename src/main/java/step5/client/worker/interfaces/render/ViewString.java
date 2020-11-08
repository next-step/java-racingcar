package step5.client.worker.interfaces.render;

public enum ViewString {
    NEWLINE(System.lineSeparator()),
    MOVE_CHAR("-"),
    DELIMITER(":"),
    SPACE(" "),
    ;

    private final String value;

    ViewString(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
