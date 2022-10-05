package view;

public class RacingInput {

    private final int carCount;
    private final int trialCount;

    public RacingInput(final int carCount, final int trialCount) {
        this.carCount = carCount;
        this.trialCount = trialCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTrialCount() {
        return trialCount;
    }
}
