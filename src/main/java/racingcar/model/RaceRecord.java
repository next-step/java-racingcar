package racingcar.model;

public class RaceRecord {
    private String carName;
    private int carMovingDistance;

    public RaceRecord(String carName, int movingDistance) {
        this.carName = carName;
        this.carMovingDistance = movingDistance;
    }
    public String getCarName() {
        return carName;
    }

    public int getCarMovingDistance() {
        return carMovingDistance;
    }
}
