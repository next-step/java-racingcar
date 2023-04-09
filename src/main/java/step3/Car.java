package step3;

public class Car {

    private int distance;

    public Car() {
        this.distance = 0;
    }

    public int getCarDistance() {
        return this.distance;
    }

    public void forwardCar() {
        this.distance++;
    }
}
