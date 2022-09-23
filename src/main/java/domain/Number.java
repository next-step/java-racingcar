package domain;

public class Number {

    private int number;

    private Number(final String number) {

        validate(number);
        this.number = Integer.parseInt(number);
    }

    public static Number from(final String str) {

        return new Number(str);
    }

    public int getNumber() {

        return this.number;
    }

    public void nextAttempt() {

        this.number--;
    }

    public boolean isAttempt() {

        return this.number > 0;
    }

    private void validate(final String attempt) {

        validateDigit(attempt);

        if (Integer.parseInt(attempt) == 0) {
            throw new IllegalArgumentException("입력값은 1 이상이어야 합니다.");
        }
    }

    private static void validateDigit(final String str) {

        for (int i = 0; i < str.length(); i++) {
            validateDigitByChar(str.charAt(i));
        }
    }

    private static void validateDigitByChar(final char charAt) {

        if (!Character.isDigit(charAt)) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }
}
