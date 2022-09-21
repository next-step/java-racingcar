package study.racing.step3;

public class Car implements Movable {
    private int distance;

    public Car() {
        distance = 0;
    }

    public void move() {
        this.distance++;
    }

    public int getDistance() {
        return this.distance;
    }
}