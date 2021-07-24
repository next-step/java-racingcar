package racing.model;

import java.util.Objects;

public class Car implements Racer, Comparable<Car> {
    private static final String MARK = "-";

    private String name;
    private String position;

    private Car(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String name, String position) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(position);
        return new Car(name, position);
    }

    @Override
    public Car go() {
        this.position += MARK;
        return this;
    }

    @Override
    public String position() {
        return position;
    }

    public String name() {
        return name;
    }

    @Override
    public int compareTo(Car o) {
        return this.position.length() - o.position.length();
    }
}
