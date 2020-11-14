package racingcar;

public class Car {
    private int location;

    public Car(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public void move() {
        location++;
    }
}
