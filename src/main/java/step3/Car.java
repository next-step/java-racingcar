package step3;

public class Car {
    private int distance;

    public Car() {
        this.distance = 0;
    }

    public void move(int distance) {
        this.distance += distance;
    }

    public int getDistance() {
        return distance;
    }
}
