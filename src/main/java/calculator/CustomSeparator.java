package calculator;

enum CustomSeparator {
    CHAR_INDEX_BEFORE_SECOND_SEPARATOR(0),
    CHAR_INDEX_BEFORE_SEPARATOR(1),
    SEPARATOR_INDEX(2),
    CHAR_INDEX_AFTER_SEPARATOR(3),
    INPUT_BEGIN_INDEX(4);

    private final int value;
    CustomSeparator(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
