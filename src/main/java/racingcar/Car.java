package racingcar;

public class Car {
    private Distance distance = new Distance();

    public Distance getDistance() {
        return distance;
    }

    public void move() {
        distance = distance.increase();
    }
}
