package racingcar;

public class Car {
    private Distance distance;
    private String name;

    public Car(int distance) {
        this.distance = new Distance(distance);
    }

    public Car() {
        this(0);
    }

    public Car(String name) {
        this.name = name;
    }

    public Distance getDistance() {
        return distance;
    }

    public void move() {
        distance = distance.increase();
    }

    public String getName() {
        return name;
    }
}
