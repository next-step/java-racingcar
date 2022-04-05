package me.devyonghee.basic;

final class StringNumber {

    private static final int DEFAULT_NUMBER = 0;
    private final String string;

    StringNumber(String string) {
        validate(string);
        this.string = string;
    }

    static StringNumber from(String string) {
        return new StringNumber(string);
    }

    int zeroOrPositiveInt() {
        if (isBlank(this.string)) {
            return DEFAULT_NUMBER;
        }
        return parseZeroOrPositiveInt();
    }

    private void validate(String string) {
        if (isBlank(string)) {
            return;
        }
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("string(%s) must be character in the number format", string), e);
        }
    }

    private int parseZeroOrPositiveInt() {
        int integer = Integer.parseInt(string);
        if (isNegative(integer)) {
            throw new IllegalStateException(String.format("string(%s) can not parse positive int", string));
        }
        return integer;
    }

    private boolean isNegative(int integer) {
        return integer < 0;
    }

    private boolean isBlank(String target) {
        return target == null || target.isBlank();
    }
}
