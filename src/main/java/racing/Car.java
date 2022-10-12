package racing;

import java.util.Objects;

public class Car {
    private int distance;
    private String name;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int distance) {
        validName(name);
        this.name = name;
        this.distance = distance;
    }

    public void run(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) { distance += 1; }
    }

    public String getName() {
        return name;
    }

    public boolean isWinner(Car other) {
        return this.distance >= other.distance;
    }

    public void printDistance() {
        ResultView.printDistance(name, distance);
    }

    @Override
    public String toString() {
        return "Car{" +
                "distance=" + distance +
                ", name='" + name + '\'' +
                '}';
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
        return Objects.hash(distance, name);
    }

    private void validName(String name) {
        if (name.length() > 5) {
            throw new RuntimeException("최대 5글자까지 입력 가능합니다.");
        }
    }
}
