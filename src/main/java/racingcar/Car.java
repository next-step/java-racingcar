package racingcar;

public class Car {

    private int location;

    public Car() {
        this.location = 1;
    }

    public int getLocation() {
        return location;
    }

    public void move() {
        ++location;
    }

}
