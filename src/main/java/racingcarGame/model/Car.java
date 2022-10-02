package racingcarGame.model;

import racingcarGame.util.RandomNumber;

import java.util.Objects;

public class Car {
    private static final int RANDOM_BASE_VALUE = 4;

    private int position;

    public Car(int position) {
        this.position = position;
    }

    public void move(int chosenNumber) {
        if (isMovable(chosenNumber)) {
            this.position += 1;
        }
    }

    public int pickRandomlyNumber(){
        return RandomNumber.generate();
    }

    boolean isMovable(int num) {
        return num >= RANDOM_BASE_VALUE;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
