package carracing;

public class Car {
    private int moveStatus;

    public Car() {
        this.moveStatus = 0;
    }

    public int getMoveStatus() {
        return moveStatus;
    }

    public void move(int value) {
        final int FORWARD_REFERENCE_NUM = 4;
        if (value >= FORWARD_REFERENCE_NUM) {
            this.moveStatus += 1;
        }
    }
}
