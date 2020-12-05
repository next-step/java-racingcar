package racing;

public class Car {
    public static final int LOW_POWER = 3;
    public static final int MOVE_POSITION = 1;
    private int position;

    public void move(int power) {
        this.position = power > LOW_POWER ? this.position + MOVE_POSITION : this.position;
    }

    public int getPosition() {
        return this.position;
    }
}
