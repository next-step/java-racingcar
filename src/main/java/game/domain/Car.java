package game.domain;

public class Car {
    private static final int MOVING_RANGE = 1;

    private final CarName carName;
    private final MovePolicy movePolicy;
    private int position;

    public Car(CarName carName, int position, MovePolicy movePolicy) {
        this.carName = carName;
        this.position = position;
        this.movePolicy = movePolicy;
    }

    public void move() {
        if (movePolicy.isMovable()) {
            position += MOVING_RANGE;
        }
    }

    public boolean isWin(int otherPosition) {
        return position >= otherPosition;
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }
}
