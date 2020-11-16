package racingcar;

public class Car {
    private int location;
    private final String name;

    private final static int MOVE_POINT = 4;

    public Car(int location, String name) {
        this.location = location;
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
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
