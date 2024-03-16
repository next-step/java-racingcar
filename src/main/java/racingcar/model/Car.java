package racingcar.model;

import java.util.Objects;

public class Car {
    private String name;
    private int distance;

    public Car(String name, int distance) {
        if(isCarName(name)) {
            throw new IllegalArgumentException("이름이 5자 초과합니다.");
        }
        if(isCarDistance(distance)) {
            throw new IllegalArgumentException("거리가 음수입니다.");
        }
        this.name = name;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void move(boolean isMove) {
        if(isMove) {
            distance += 1;
        }
    }

    public boolean isMaxDistance(int maxDistance) {
        return this.distance == maxDistance;
    }

    private boolean isCarName(String carName) {
        return carName.length() > 5;
    }

    private boolean isCarDistance(int distance) {
        return distance < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }

}
