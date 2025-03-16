package game;

public class Car {
    private static final int MOVE_CONDITION = 4;

    private final PositiveInteger position;

    public Car() {
        this.position = new PositiveInteger(0);
    }

    public void move(int number) {
        if (number >= MOVE_CONDITION) {
            position.addOne();
        }
    }

    public int getPosition() {
        return position.getValue();
    }
}
