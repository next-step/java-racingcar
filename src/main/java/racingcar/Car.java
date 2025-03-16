package racingcar;

public class Car {
    private int distance;

    public Car() {
        this.distance = 0;
    }

    public Car(int distance) {
        this.distance = distance;
    }

    public void move() {
        distance += 1;
    }

    public int getDistance() {
        return distance;
    }
}
