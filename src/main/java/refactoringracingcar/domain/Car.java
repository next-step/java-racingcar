package refactoringracingcar.domain;

public class Car {

    private static final int CAR_DEFAULT_POSITION = 0;
    private final String carName;
    private int carPosition;

    public Car(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public Car(String carName) {
        this.carName = carName;
        this.carPosition = CAR_DEFAULT_POSITION;
    }

    public int moveCarUnit(boolean discriminationMove) {
        if (discriminationMove) {
            return 1;
        }
        return 0;
    }

    public void move(int moveDistance) {
        setCarPosition(getCarPosition() + moveDistance);
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
