package step_2;

public enum MessageConstants {
    IS_NULL_OR_BLANK("Sentence Must Not be null or blank"),
    NOT_MATCH_OPERATOR("Not Supported Operation symbol."),
    DOES_NOT_SUPPORTED("Does not supported Sentence"),
    DIVIDE_BY_ZERO("Not Division By 0");

    private final String message;

    MessageConstants(String message) {
        this.message = message;
    }

    public void sendViolation() {
        throw new IllegalArgumentException(message);
    }

    public String getMessage() {
        return this.message;
    }
}
