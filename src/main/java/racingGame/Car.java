package racingGame;

import java.util.Objects;

public class Car {

    public static final int MOVABLE_LIMIT_NUMBER = 4;

    private final String name;
    private final int distance;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int distance) {
        validName(name);
        this.name = name;
        this.distance = distance;
    }

    public Car move(int random) {
        if (random >= MOVABLE_LIMIT_NUMBER) {
            return new Car(name, distance + 1);
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    private void validName(String name) {
        if (name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return distance == car.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

}
