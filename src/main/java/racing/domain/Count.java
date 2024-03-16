package racing.domain;

public class Count {
    private final int value;

    public Count(String value) {
        this.value = toInt(value);
    }

    public int value() {
        return value;
    }

    private int toInt(String input) {
        if (hasNoInput(input)) {
            throw new IllegalArgumentException("Null 또는 공백 입력");
        }

        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }

        if (isZeroOrNegativeNumber(number)) {
            throw new IllegalArgumentException("양의 정수만 입력할 수 있습니다.");
        }
        return number;
    }

    private boolean hasNoInput(String str) {
        return str == null || str.isBlank();
    }

    private boolean isZeroOrNegativeNumber(int number) {
        return number <= 0;
    }
}
