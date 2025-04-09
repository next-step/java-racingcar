package domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final String name;
    private final Position position;

    public Car(String name) {
        this(name, new Position(0));
    }

    public Car(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    /**
     * 이름이 같으면 같은 차로 간주
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car)o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    /**
     * 위치 비교는 position의 위치 비교
     */
    @Override
    public int compareTo(Car o) {
        return position.getValue() - o.position.getValue();
    }
}
