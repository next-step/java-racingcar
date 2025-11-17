package racing.domain;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private static final int MOVE_THRESHOLD = 4;

    private int position;

    public Car() {
        this.position = DEFAULT_POSITION;
    }

    public void move(int number) {
        if (canMove(number)) {
            position++;
        }
    }

    private boolean canMove(int number) {
        return number >= MOVE_THRESHOLD;
    }

    public int getPosition() {
        return position;
    }
}
