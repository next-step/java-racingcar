package racing;

public class SimpleCar implements Car {

    private int currentPosition = 0;
    private static final int MOVE_CONDITION = 4;

    public void move(int diceResult) {
        if (diceResult >= MOVE_CONDITION) {
            currentPosition++;
        }
    }

    public int currentPosition() {
        return currentPosition;
    }

    @Override
    public String name() {
        return "";
    }
}
