package racing.domain;

public class TryNumber {

    private static final int MIN_TRY_NUMBER = 1;

    private int tryNumber;

    public TryNumber(int tryNumber) {
        isValidTryNumber(tryNumber);
        this.tryNumber = tryNumber;
    }

    //TODO: 메서드명 변경
    private void isValidTryNumber(final int tryNumber) {
        if (tryNumber < MIN_TRY_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 최소 1회 이상이어야 합니다.");
        }
    }
    
    public boolean nextStep() {
        if (this.tryNumber == 0) {
            return false;
        }
        decrease();
        return true;
    }

    private void decrease() {
        this.tryNumber -= 1;
    }
}
