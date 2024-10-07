package racingcar.model;

public class RaceRecord {
    private String carName;
    private String dashCharacterString;

    public RaceRecord(String carName, int movingDistance) {
        this.carName = carName;
        this.dashCharacterString = "-".repeat(movingDistance);
    }

    public String getDashCharacterString() {
        return dashCharacterString;
    }

    public String getCarName() {
        return carName;
    }
}
