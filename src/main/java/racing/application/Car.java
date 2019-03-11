package racing.application;

public class Car {
    private int position = 1;

    public int move(boolean canMove) {
        if (canMove) {
            return ++position;
        }

        return position;
    }

    public int getPosition() {
        return position;
    }
}
