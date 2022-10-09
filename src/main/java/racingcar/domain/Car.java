package racingcar.domain;

import static racingcar.domain.moving.Moving.*;

import java.util.Objects;

import racingcar.domain.moving.Moving;

public class Car implements Comparable<Car> {
    private static final int GREATER = 1;
    private static final int EQUALS = 0;
    private static final int LESS = -1;
    
    private final String name;
    private Distance total;

    public Car(String name) {
        this.name = name;
        this.total = Distance.ZERO;
    }
    
    public Car(String name, Distance total) {
        this.name = name;
        this.total = total;
    }

    public Distance move(Moving moving) {
        if (moving == GO) {
            total = total.increment();
        }
        return total;
    }

    public String name() {
        return name;
    }
    
    public int distance() {
        return total.getDistance();
    }

    @Override
    public int compareTo(Car car) {
        if (total.greaterThan(car.total)) {
            return GREATER;
        }
        if (total.equals(car.total)) {
            return EQUALS;
        }
        return LESS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(total, car.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, total);
    }
}
