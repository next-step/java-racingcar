package calculator.model;

import calculator.util.StringUtils;

public final class NonNegativeNumber {

    private final int value;

    private NonNegativeNumber(final int value) {
        this.value = value;
    }

    public static NonNegativeNumber of(final String value) {
        if (StringUtils.hasNotText(value)) {
            return new NonNegativeNumber(0);
        }

        return of(toInt(value));
    }

    public static NonNegativeNumber of(final int value) {
        if (isNegativeNumber(value)) {
            throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
        }

        return new NonNegativeNumber(value);
    }

    public int intValue() {
        return this.value;
    }

    private static boolean isNegativeNumber(final int value) {
        return value < 0;
    }

    private static int toInt(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 잘못된 형식의 값을 입력했습니다.", e);
        }
    }
}
