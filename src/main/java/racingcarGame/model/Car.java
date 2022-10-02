package racingcarGame.model;

import racingcarGame.util.RandomNumber;

public class Car {
    private static final int RANDOM_BASE_VALUE = 4;

    private int position;
    private String name;

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public void move(int chosenNumber) {
        if (isMovable(chosenNumber)) {
            this.position += 1;
        }
    }

    public int pickRandomlyNumber() {
        return RandomNumber.generate();
    }

    boolean isMovable(int num) {
        return num >= RANDOM_BASE_VALUE;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

}
