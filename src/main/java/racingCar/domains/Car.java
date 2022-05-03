package racingCar.domains;

import racingCar.utils.RandomNumberGenerator;

import java.util.Objects;

public class Car {
    private Name name;
    private int position;
    private NumberGeneratorStrategy strategy;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this(name, new RandomNumberGenerator(), position);
    }

    public Car(String name, NumberGeneratorStrategy strategy) {
        this(name, strategy, 0);
    }

    public Car(String name, NumberGeneratorStrategy strategy, int position) {
        this.name = new Name(name);
        this.strategy = strategy;
        this.position = position;
    }

    public void move() {
        if (strategy.generate() >= 4) {
            position++;
        }
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
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

    public boolean isWinner(int max) {
        return this.position == max;
    }
}
