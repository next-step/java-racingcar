package domain;

public class DefaultCarDisplacement implements CarDisplacement {
    private final int moveValue;

    private DefaultCarDisplacement(int moveValue) {
        this.moveValue = moveValue;
    }

    public static CarDisplacement create(int moveValue) {
        return new DefaultCarDisplacement(moveValue);
    }

    @Override
    public int move() {
        return moveValue;
    }
}
