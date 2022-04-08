package step2;

public class Positive {
    private static final String NUMBER_REGEX_EXP = "^\\+?[0-9]\\d*$";
    private final int value;

    Positive(String text) {
        this.value = validatePositiveNumber(text);
    }

    private int validatePositiveNumber(String text) {
        if (isPositiveNumber(text)) {
            return Integer.parseInt(text);
        }
        throw new IllegalArgumentException(String.format("%s이 아닌 0 혹은 양수를 입력해주세요.", text));
    }

    private boolean isPositiveNumber(String text) {
        return text.matches(NUMBER_REGEX_EXP);
    }

    public int add(int value) {
        return this.value + value;
    }
}
