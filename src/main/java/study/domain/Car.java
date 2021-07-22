package study.domain;

public class Car {

    private Distance distance;

    public Car() {
        distance = new Distance();
    }

    public Car(int move) {
        this.distance = new Distance(move);
    }

    public static Car createCar() {
        return new Car();
    }

    public Distance getDistance() {
        return distance;
    }

}
