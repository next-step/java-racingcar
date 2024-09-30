package racing.input;

public class RaceInput {

    private final CarInfo carNumber;
    private final RaceAttempt attemptNumber;

    public RaceInput(String carInfo, int numOfAttempt) {
        this.carNumber = CarInfo.of(carInfo);
        this.attemptNumber = RaceAttempt.of(numOfAttempt);
    }

    public CarInfo carInfo() {
        return carNumber;
    }

    public RaceAttempt getAttemptNumber() {
        return attemptNumber;
    }
}
