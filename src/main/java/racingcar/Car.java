package racingcar;

public class Car {

    private int location;

    public Car(int location) {
        this.location = location;
    }

    public void move() {
        location += 1;
    }

    public int getCarLocation() {
        return location;
    }
}