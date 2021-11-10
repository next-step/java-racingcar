package racinggame;

public class Car {
    private static final int INIT_POSITION = 0;
    private int position;

    public Car() {
        this.position = INIT_POSITION;
    }

    public void move(boolean movable) {
        if (movable) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
