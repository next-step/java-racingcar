package racing.domain;

public class TryNumber {

    private final int tryNumber;

    public TryNumber(String tryNumber) {
        try {
            this.tryNumber = toInt(tryNumber);
            checkTryNumber(this.tryNumber);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("[ERROR] 숫자만 입력 해주세요.");
        }
    }

    private int toInt(String tryNumber) {
        return Integer.parseInt(tryNumber);
    }

    private static void checkTryNumber(final int tryNumber) {
        if (tryNumber <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 최소 1회 이상이어야 합니다.");
        }
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
