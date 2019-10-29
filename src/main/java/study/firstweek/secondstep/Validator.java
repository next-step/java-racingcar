package study.firstweek.secondstep;

public class Validator {

    private final int MINIMUM_CAR = 1;
    private final int MINIMUM_TRIAL = 1;

    public void validateNumberOfCars(int carCount) {
        if (carCount < MINIMUM_CAR) {
            throw new IllegalArgumentException("not valid number of cars");
        }
    }

    public void validateNumberOfTrials(int trial) {
        if (trial < MINIMUM_TRIAL) {
            throw new IllegalArgumentException("not valid number of trials");
        }
    }
}
