package study.racing.domain;

public class Car {

    private Distance distance;

    public Car() {
        distance = new Distance();
    }

    public static Car createCar() {
        return new Car();
    }

    public Distance getDistance() {
        return distance;
    }

}
