package Domain;

public class CarInfo {
    private String carName;
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
