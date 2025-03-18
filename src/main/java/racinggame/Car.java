package racinggame;

public class Car {

    private int position = 1;
    private static final int MOVEMENT_THRESHOLD = 4;

    public int position() {
        return this.position;
    }

    public void move(final int randomNumber) {
        if (randomNumber >= MOVEMENT_THRESHOLD) {
            this.position++;
        }
    }
}
