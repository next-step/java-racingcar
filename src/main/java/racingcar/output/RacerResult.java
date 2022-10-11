package racingcar.output;

import racingcar.Car;

public class RacerResult {

    private String carName;
    private int carPosition;

    private RacerResult() {
    }

    public RacerResult(final String carName, final int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public static RacerResult from(final Car car) {
        return new RacerResult(car.getName(), car.getPosition());
    }

    public String getCarName() {
        return this.carName;
    }

    public int getCarPosition() {
        return this.carPosition;
    }
}
