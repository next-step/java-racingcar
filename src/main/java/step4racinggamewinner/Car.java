package step4racinggamewinner;

public class Car {
    private final String carName;
    private Position position;

    public Car(String carName) {
        this(carName, 0);
    }

    public Car(String carName, int positionNumber) {
        this.carName = carName;
        position = new Position(positionNumber);
    }

    public void updateMovement(int movement) {
        position.updateMovement(movement);
    }

    public int currentPosition() {
        return position.currentPosition();
    }

    public String carName() {
        return this.carName;
    }

}
