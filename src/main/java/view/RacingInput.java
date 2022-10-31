package view;

public class RacingInput {

    private final String carNames;
    private final int trialCount;

    public RacingInput(final String carNames, final int trialCount) {
        this.carNames = carNames;
        this.trialCount = trialCount;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getTrialCount() {
        return trialCount;
    }
}
