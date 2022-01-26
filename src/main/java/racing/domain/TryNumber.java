package racing.domain;

public class TryNumber {

    private static final int MIN_TRY_NUMBER = 1;

    private final int tryNumber;

    public TryNumber(String tryNumber) {
        this.tryNumber = toInt(tryNumber);
        isValidTryNumber(this.tryNumber);
    }

    private int toInt(String tryNumber) {
        try {
            return Integer.parseInt(tryNumber);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("[ERROR] 숫자만 입력 해주세요.");
        }
    }

    private static void isValidTryNumber(final int tryNumber) {
        if (tryNumber < MIN_TRY_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 최소 1회 이상이어야 합니다.");
        }
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
