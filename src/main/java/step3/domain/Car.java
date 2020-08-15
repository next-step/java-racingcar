package step3.domain;

public class Car {

    private int distance;

    public Car() {
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public int moveCar(boolean move) {
        return move ? this.distance++ : this.distance;
    }

}
