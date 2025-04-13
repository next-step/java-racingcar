package domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final Name name;
    private Position position;

    public Car(String name) {
        this(name, new Position(0));
    }

    public Car(String name, Position position) {
        this.name = new Name(name);
        this.position = position;
    }

    /**
     * 조건에 따른 차량 이동 메서드
     */
    public void moveWithCondition(boolean condition) {
        if (condition) {
            this.position = position.move();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car)o;
        return name.getName().equals(car.name.getName());
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

    public boolean isSamePosition(int Position) {
        return this.position.getValue() == Position;
    }

    public int getPositionValue() {
        return position.getValue();
    }

    public String getName() {
        return name.getName();
    }
}
