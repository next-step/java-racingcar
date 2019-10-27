package step1;

public enum OperationType {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String rawString;

    OperationType(final String rawString) {
        this.rawString = rawString;
    }

    public String text() {
        return rawString;
    }
}
