package racingcar;

public class Car {
    private static final int MOVE_STANDARD = 4;
    private static final int DEFAULT_DISTANCE = 1;

    private int position = 0;

    public void move(int number) {
        if (number >= MOVE_STANDARD) {
            this.position += DEFAULT_DISTANCE;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
