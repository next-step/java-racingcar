package racingcar.domain;

public class Car {
    private Distance distance = new Distance();
    private final Name name;

    public Car(Name name) {
        this.name = name;
    }

    public Distance getDistance() {
        return distance;
    }

    public void move() {
        distance = distance.increase();
    }

    public Name getName() {
        return name;
    }
}
