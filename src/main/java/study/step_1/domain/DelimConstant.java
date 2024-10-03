package study.step_1.domain;

public enum DelimConstant {

    DELIMITER_COMMA(','),
    DELIMITER_COLON(':');

    private final char value;

    DelimConstant(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}