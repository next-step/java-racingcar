package racingcar.domain;

public class RacerRecord {

    private final String carName;
    private final int carPosition;

    public RacerRecord(final String carName, final int carPosition) {
        validateCarName(carName);
        this.carName = carName;
        this.carPosition = carPosition;
    }

    private void validateCarName(final String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 누락되었습니다.");
        }
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
