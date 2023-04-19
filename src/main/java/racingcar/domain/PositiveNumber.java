package racingcar.domain;

public class PositiveNumber {

    public static final int ZERO = 0;
    private final int number;

    public PositiveNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static PositiveNumber create(String stringNumber) {

        int convertedNumber = convertStringToNumber(stringNumber);
        if (convertedNumber < ZERO) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }

        return new PositiveNumber(convertedNumber);
    }

    private static int convertStringToNumber(String stringNumber) throws NumberFormatException {
        try {
            return Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자 이외의 값은 입력할 수 없습니다.");
        }
    }
}
