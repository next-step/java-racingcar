package racing.entity;

import java.util.Random;

public class Car {

    private final CarName carName;
    private Position position;
    private final Random random = new Random();

    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_RANGE = 10;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.position = new Position(0);
    }

    public String getName() {
        return carName.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }

    public void move() {
        int randomValue = random.nextInt(RANDOM_RANGE);
        if (canMove(randomValue)) {
            position = position.movePosition();
        }
    }

    protected boolean canMove(int randomValue) {
        return randomValue >= MOVE_THRESHOLD;
    }

    public boolean isPosition(int maxPosition) {
        return position.getValue() == maxPosition;
    }

}
