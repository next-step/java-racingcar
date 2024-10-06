package step4racinggamewinner;

public class Car {
    private final String carName;
    private Position position;

    public Car(String carName) {
        this.carName = carName;
        position = new Position(0);
    }

    public void updateMovement(int movement) {
        position.updateMovement(movement);
    }

    public int currentMovement() {
        return position.currentMovement();
    }
}
