package step5.worker.interfaces.render;

public enum ViewString {
    NEWLINE(System.lineSeparator()),
    RESULT_ANNOUNCEMENT(NEWLINE + "실행결과" + NEWLINE),
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
