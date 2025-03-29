package racingcar.domain;

public class TrialCoin {

    private static final int MIN_TRIAL_COUNT = 0;
    private static final int DECREASE_AMOUNT = 1;

    private int trialCoin;

    public TrialCoin(int value) {
        validateNotNegative(value);
        this.trialCoin = value;
    }

    public boolean isCoinLeft() {
        return trialCoin > 0;
    }

    public void decrease() {
        trialCoin -= DECREASE_AMOUNT;
    }

    private void validateNotNegative(int rest) {
        if (rest < MIN_TRIAL_COUNT) {
            throw new IllegalArgumentException("시도횟수는 음수이면 안됩니다");
        }
    }
}
