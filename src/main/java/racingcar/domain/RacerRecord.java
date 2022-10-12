package racingcar.domain;

public class RacerRecord {

    private String carName;
    private int carPosition;

    private RacerRecord() {
    }

    public RacerRecord(final String carName, final int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public static RacerRecord from(final Car car) {
        return new RacerRecord(car.getName(), car.getPosition());
    }

    public String getCarName() {
        return this.carName;
    }

    public int getCarPosition() {
        return this.carPosition;
    }
}
