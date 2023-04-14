package study.step4;

import java.util.Random;

public class Car implements Comparable<Car> {
    private int position = 0;
    private static final Random random = new Random();
    private static final int STARTING_CONDITION = 4;
    private static final int RANDOM_RANGE = 10;
    private int attemptCount = 0;
    private String name;

    public Car(String name) {
        checkName(name);
        this.name = name;
    }

    public void checkName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름이 다섯자 이상입니다.");
        }
    }

    public void move() {
        moveCar(isMove(random.nextInt(RANDOM_RANGE)));
        attemptCount++;
    }

    public Boolean isMove(int input) {
        return input >= STARTING_CONDITION;
    }

    public void moveCar(boolean moveResult) {
        if (moveResult) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public String getCarName() {
        return name;
    }

    @Override
    public int compareTo(Car car) {
        return (this.position > car.position) ? 1 : -1;
    }
}
