package step3;

public class Car {

    private static final int MOVABLE_POWER = 4;
    private int position;

    public Car() {
        this.position = 1;
    }

    public int getCurrentPosition() {
        return this.position;
    }

    public void moveForward(int power) {
        if (power >= MOVABLE_POWER) {
            this.position++;
        }
    }
}
