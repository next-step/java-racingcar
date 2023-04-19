package racingcar;

public class CarScore {
    private String carName;
    private Integer carPosition;

    public CarScore(String carName, Integer carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public String getCarName() {
        return carName;
    }

    public Integer getCarPosition() {
        return carPosition;
    }
}
