package racing.application;

public class Car {
    private int position = 1;

    public int move(boolean canMove) {
        if (canMove) {
            return ++position;
        }

        return position;
    }

    protected boolean canMove(Validation validation) {
        return validation.check();
    }

    public int getPosition() {
        return position;
    }
}
