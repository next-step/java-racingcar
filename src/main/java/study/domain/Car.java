package study.domain;

import study.policy.RacingCarPolicy;
import study.util.RandomNumberGenerator;

import java.util.Objects;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name.trim();
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moving() {
        if (RacingCarPolicy.canMovingCar(getRandomNumber())) {
            this.position += 1;
        }
    }

    public void moving(int num) {
        if (RacingCarPolicy.canMovingCar(num)) {
            this.position += 1;
        }
    }

    protected int getRandomNumber() {
        return RandomNumberGenerator.getRandomNumber();
    }

    public boolean matchPosition(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
