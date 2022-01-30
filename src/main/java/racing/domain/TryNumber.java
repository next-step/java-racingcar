package racing.domain;

public class TryNumber {

    private static final int MIN_TRY_NUMBER = 1;

    private int tryNumber;

    public TryNumber(int tryNumber) {
        checkValidTryNumber(tryNumber);
        this.tryNumber = tryNumber;
    }
    
    private void checkValidTryNumber(final int tryNumber) {
        if (tryNumber < MIN_TRY_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 최소 1회 이상이어야 합니다.");
        }
    }

    public boolean hasNextStep() {
        if (this.tryNumber == 0) {
            return false;
        }
        return true;
    }

    public void nextStep() {
        checkValidTryNumber(this.tryNumber);
        decrease();
    }

    private void decrease() {
        this.tryNumber -= 1;
    }
}
