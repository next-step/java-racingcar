package domain;

import java.util.Objects;

public class Car implements Comparable<Car> {

    //변수 선언 순서변경
    private static final Integer MOVE = 1;

    //자동차명 final로 수정, 5글자 초과 valid를 위한 클래스로 분리
    private final CarName name;
    private int distance;

    public Car(CarName name) {
        this.name = name;
        this.distance = 0;
    }

    public CarName getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public void moveWithCondition(int value, int condition) {
        if (value >= condition) {
            this.distance = this.distance + MOVE;
        }
    }

    public boolean isSameDistanceCar(Car car) {
        return car.distance == this.distance;
    }

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

    @Override
    public int compareTo(Car other) {
        return this.distance - other.distance;
    }
}
