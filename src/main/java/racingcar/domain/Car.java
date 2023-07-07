package racingcar.domain;

import java.util.Random;

public class Car {

    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_THRESHOLD = 4;
    private final CarName name;
    private final Random random;
    private Position position;

    public Car(CarName name) {
        this.name = name;
        this.random = new Random();
        this.position = new Position();
    }

    public Car(CarName name, Random random) {
        this.name = name;
        this.random = random;
        this.position = new Position();
    }

    public void move() {
        if (canMove(random.nextInt(RANDOM_BOUND))) {
            updatePosition(this.position.increaseValue());
        }
    }

    private boolean canMove(int value) {
        return value >= MOVE_THRESHOLD;
    }

    private void updatePosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public String getName() {
        return name.getValue();
    }

    public boolean isWinner(Position winnerPosition) {
        return this.position.equals(winnerPosition);
    }

}
