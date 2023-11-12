package racing.domain;

public class Car {
    private final int MOVE_THRESHOLD = 4;

    private final Position position;

    private final CarName carName;

    public Car(String carName) {
        this.position = new Position(0);
        this.carName = new CarName(carName);
    }

    public Position getPosition() {
        return this.position;
    }

    public boolean isFartherOrEqual(int maxPosition) {
        return this.position.getValue() >= maxPosition;
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public void move(int input) {
        if (isMovable(input)) {
            position.move();
        }
    }

    private boolean isMovable(int input) {
        return input >= MOVE_THRESHOLD;
    }

}
