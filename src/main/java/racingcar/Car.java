package racingcar;

public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private static final int MOVE_DISTANCE = 1;
    private int position;

    public Car() {
        this(0);
    }

    public Car(int position) {
        this.position = position;
    }

    public void tryMove(int number) {
        if (number < MOVE_THRESHOLD) {
            return;
        }
        position += MOVE_DISTANCE;
    }

    public int getPosition() {
        return position;
    }
}
