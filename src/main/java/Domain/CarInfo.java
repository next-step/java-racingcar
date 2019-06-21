package Domain;

public class CarInfo {
    private String carName;
    private int carPosition;
    private String carStatus;

    public CarInfo(String carName) {
        this.carName = carName;
    }

    public int getCarPosition() {
        return carPosition;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarPositions(int carPosition) {
        this.carPosition = carPosition;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }
}
