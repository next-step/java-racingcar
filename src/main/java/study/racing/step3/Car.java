package study.racing.step3;

import java.util.Objects;

public class Car {
    private MovingCondition movingCondition;
    private int distance;

    public Car() {
        this.distance = 0;
    }

    public Car(MovingCondition movingCondition) {
        this.distance = 0;
        this.movingCondition = movingCondition;
    }

    public Car(MovingCondition movingCondition, int distance) {
        this.movingCondition = movingCondition;
        this.distance = distance;
    }

    public void move(int number) {
        if (movingCondition.movable(number)) {
            this.distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(movingCondition, car.movingCondition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movingCondition, distance);
    }
}
