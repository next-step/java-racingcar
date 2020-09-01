package step3.domain;

import java.util.Objects;

public class Car {
    private final String name;

    public Car(String name) {
        this.name = name.trim();
    }

    /* equals , hashcod 용도 스터디 필요 */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
