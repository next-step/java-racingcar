package racingcar.dto;

public class RacingInfo {
    public final String[] carsNames;
    public final int numberOfCar;
    public final int raceTrialCount;

    public RacingInfo(String[] carsNames, int numberOfCar, int raceTrialCount) {
        this.carsNames = carsNames;
        this.numberOfCar = numberOfCar;
        this.raceTrialCount = raceTrialCount;
    }
}
