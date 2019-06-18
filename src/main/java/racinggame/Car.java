package racinggame;

public class Car {
    public static final int MOVE_DISTANCE_PER_ONCE = 1;
    private int position = 1;

    public void move() {
        this.position += MOVE_DISTANCE_PER_ONCE;
    }

    public int getPosition() {
        return position;
    }
}
