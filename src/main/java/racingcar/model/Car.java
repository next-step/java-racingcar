package racingcar.model;

import racingcar.random.RandomRunnable;

import java.util.Objects;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        move(new RandomRunnable().isRunnable());
    }

    public void move(boolean isRunnable) {
        if (isRunnable) {
            position++;
        }
    }

    public boolean isWinner(int maxPositionValue) {
        return this.position == maxPositionValue;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}