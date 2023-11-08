package step3;

public class Car {
    private int distance;

    public Car() {
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public void moveCar() {
        this.distance++;
    }
}
