package racingcar;

public class Car {
    private int location;

    private final static int MOVE_POINT = 4;

    public Car(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public void move() {
        location++;
    }

    public void tryToMove() {
        if (RandomNumberUtil.getRandomNumber() >= MOVE_POINT) {
            move();
        }
    }
}
