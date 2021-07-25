package racing.model;

import java.util.Objects;

public class Car implements Racer, Comparable<Car> {
    private String name;
    private int position;

    private Car(String name) {
        this.name = name;
    }

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String name) {
        return new Car(Objects.requireNonNull(name));
    }

    public static Car deepCopy(Car car) {
        return new Car(car.name, car.position);
    }

    @Override
    public Car go() {
        this.position++;
        return this;
    }

    @Override
    public int position() {
        return position;
    }

    public String name() {
        return name;
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.position;
    }
}
