package racingcar;

public class Car {
    private int position = 0;
    private static final int THRESHOLD = 4;

    public void moveCar(int input) {
        if (input >= THRESHOLD) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
