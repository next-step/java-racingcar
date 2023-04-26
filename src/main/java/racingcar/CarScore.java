package racingcar;

public class CarScore {
    private String carName;
    private int carPosition;

    public CarScore(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }
}
