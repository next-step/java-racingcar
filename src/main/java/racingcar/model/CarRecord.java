package racingcar.model;

public class CarRecord{
    private final String carName;
    private final int carDistance;

    public CarRecord(String carName, int carDistance) {
        this.carName = carName;
        this.carDistance = carDistance;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getDistance() {
        return this.carDistance;
    }
}
