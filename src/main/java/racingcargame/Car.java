package racingcargame;

public class Car {

    private int location;

    public Car(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public void move() {
        this.location += 1;
    }
}
