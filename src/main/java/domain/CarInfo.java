package domain;

public class CarInfo {
    private final String carName;
    private int carPosition;

    public CarInfo(String carName) {
        this.carName = carName;
    }

    public int getCarPosition() {
        return carPosition;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarPositions(int carPosition) {
        this.carPosition = carPosition;
    }
}
