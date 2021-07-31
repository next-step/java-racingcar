package racingcar;

public class Car {
    private Distance distance;

    public Car(int distance) {
        this.distance = new Distance(distance);
    }

    public Car() {
        this(0);
    }

    public Distance getDistance() {
        return distance;
    }

    public void move() {
        distance = distance.increase();
    }
}
