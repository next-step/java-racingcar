package step3;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private static final int MOVE_CONDITION = 4;


    private int position = DEFAULT_POSITION;
    public void move(int number) {
        if (canMove(number)) {
            position++;
        }
    }

    private boolean canMove(int number) {
        return number >= MOVE_CONDITION;
    }

    public int getPosition() {
        return position;
    }
}
