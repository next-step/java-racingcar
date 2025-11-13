package racingcar;

public class Car {

    private static final int MOVE_THRESHOLD = 4;

    private final CarName name;
    private int position = 0;

    public Car(CarName name) {
        this.name = name;
    }

    public Car(String value) {
        this(new CarName(value));
    }

    public CarName name() {
        return name;
    }

    public int position() {
        return position;
    }

    public void moveIfPossible(int number) {
        if (number >= MOVE_THRESHOLD) {
            move();
        }
    }

    private void move() {
        position++;
    }
}
