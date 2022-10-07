package racingcar;

public class RacingResult {

    private String carName;
    private int carPosition;

    public static RacingResult from(Car car) {
        RacingResult racingResult = new RacingResult();
        racingResult.carName = car.name();
        racingResult.carPosition = car.position();

        return racingResult;
    }

    public String carName() {
        return this.carName;
    }

    public int carPosition() {
        return this.carPosition;
    }
}
