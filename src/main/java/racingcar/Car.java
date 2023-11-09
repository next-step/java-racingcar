package racingcar;

public class Car {
    private static final int THRESHOLD = 4;
    private int position = 0;

    public void moveForward(int input) {
        if (input >= THRESHOLD) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
