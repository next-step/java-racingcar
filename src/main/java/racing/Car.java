package racing;

public class Car {
    private static final int MOVE_MIN_NUMBER = 4;
    private int position;

    public int move(int diceNumber) {
        if (isMoveTime(diceNumber)) {
            position++;
        }

        return position;
    }

    private boolean isMoveTime(int diceNumber) {
        return diceNumber >= MOVE_MIN_NUMBER;
    }
}
