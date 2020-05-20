package racing;

public class Car {
    private static final int MOVE_MIN_NUMBER = 4;
    private int position;

    public int showMyPosition() {
        return position;
    }

    public void move() {
        if (isMoveTime()) {
            this.position++;
        }
    }

    private boolean isMoveTime() {
        return Dice.cast() >= MOVE_MIN_NUMBER;
    }
}
