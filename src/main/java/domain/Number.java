package domain;

public class Number {

    private static final int ZERO = 0;

    private int number;

    private Number(final String number) {

        validate(number);
        this.number = Integer.parseInt(number);
    }

    public static Number from(final String str) {

        return new Number(str);
    }

    private void validate(final String attempt) {

        validateDigit(attempt);

        if (Integer.parseInt(attempt) == ZERO) {
            throw new IllegalArgumentException("입력값은 1 이상이어야 합니다.");
        }
    }

    private static void validateDigit(final String str) {

        for (int i = 0; i < str.length(); i++) {
            validateDigit(str.charAt(i));
        }
    }

    private static void validateDigit(char c) {

        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }

    public int getNumber() {

        return number;
    }

    public void nextAttempt() {

        this.number--;
    }

    public boolean isAttempt() {

        return this.number > 0;
    }
}
