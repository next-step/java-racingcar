package racingcar.domain;

public class TryCount {

    private static final int MIN_COUNT = 1;

    private final int number;

    public TryCount(String number) {
        this.number = parseNumberOrThrow(number);
        if (isNotInRage(this.number)) {
            throw new IllegalArgumentException("범위에 포함되지 않는 숫자입니다. 1 이상의 숫자를 입력하세요.");
        }
    }

    private int parseNumberOrThrow(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력받을 수 있습니다.");
        }
    }

    private boolean isNotInRage(int number) {
        return number < MIN_COUNT;
    }

    public int getNumber() {
        return number;
    }
}
