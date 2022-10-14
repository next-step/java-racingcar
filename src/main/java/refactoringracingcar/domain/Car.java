package refactoringracingcar.domain;

public class Car {

    private final String carName;
    private int carPosition;

    public Car(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getCarPosition() {
        return this.carPosition;
    }

    public void setCarPosition(int carPosition) {
        this.carPosition = carPosition;
    }
}
