package racingcar;

public class Car {
    private Distance distance;

    public Distance getDistance() {
        return distance;
    }

    public void move() {
        distance = distance.increase();
    }
}
