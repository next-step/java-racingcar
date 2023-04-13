package racingcar;

public class Car {

    private int distance = 1;

    public void move() {
        this.distance += 1;
    }

    public int getDistance() {
        return distance;
    }
}
