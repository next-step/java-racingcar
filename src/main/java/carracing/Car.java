package carracing;

public class Car {
    private static final int MOVE_REFERENCE_NUM = 4;
    private int moveStatus;

    public Car() {
        this.moveStatus = 0;
    }

    public int getMoveStatus() {
        return moveStatus;
    }

    public void move(int value) {
        if (value >= MOVE_REFERENCE_NUM) {
            this.moveStatus += 1;
        }
    }
}
