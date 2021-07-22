package study.domain;

public class Car {

    private Distance distance;

    public Car(int move) {
        this.distance = new Distance(move);
    }

    public Distance getDistance() {
        return distance;
    }
}
