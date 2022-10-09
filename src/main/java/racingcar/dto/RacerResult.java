package racingcar.dto;

import racingcar.Car;

public class RacerResult {

    private String carName;
    private int carPosition;

    private RacerResult() {
    }

    public static RacerResult from(final Car car) {
        RacerResult racerResult = new RacerResult();
        racerResult.carName = car.getName();
        racerResult.carPosition = car.getPosition();

        return racerResult;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getCarPosition() {
        return this.carPosition;
    }
}
