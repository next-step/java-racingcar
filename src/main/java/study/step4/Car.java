package study.step4;

import java.util.Random;

public class Car implements Comparable<Car> {
    private static final int STARTING_CONDITION = 4;
    private static final int RANDOM_RANGE = 10;
    private static final Random RANDOM = new Random();

    private int attemptCount = 0;
    private Position position;
    private Name name;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move() {
        moveCar(isMove(RANDOM.nextInt(RANDOM_RANGE)));
        attemptCount++;
    }

    public Boolean isMove(int input) {
        return input >= STARTING_CONDITION;
    }

    private void moveCar(boolean moveResult) {
        if (moveResult) {
            position.increase();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public int compareTo(Car car) {
        return (this.position.getPosition() > car.position.getPosition()) ? 1 : -1;
    }
}
