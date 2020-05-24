package racing;

public class Car {
    private static final int MOVE_MIN_NUMBER = 4;
    private int position;

    public int showMyPosition() {
        return position;
    }

    public void move(int diceNumber) {
        if (isMoveTime(diceNumber)) {
            this.position++;
        }
    }

    private boolean isMoveTime(int diceNumber) {
        return diceNumber >= MOVE_MIN_NUMBER;
    }
}
