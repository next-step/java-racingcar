package racingcar;

public class Car {

    private int location = 0;

    public void move() {
        location += 1;
    }

    public int getCarLocation() {
        return location;
    }
}