package racing;

public class Car {
    private static final int MOVE_MIN_NUMBER = 4;
    private int position;

    public void drive() {
        if (isMoveTime(Dice.cast())) {
            move();
        }
    }

    public int showMyPosition() {
        return position;
    }

    private void move() {
        this.position++;
    }

    private boolean isMoveTime(int castNumber) {
        return castNumber >= MOVE_MIN_NUMBER;
    }
}
