package racing;

public class BasicEngine implements Engine {

    private final int DEFAULT_MOVABLE_NUMBER = 4;
    private int movableNumber = DEFAULT_MOVABLE_NUMBER;

    BasicEngine() {
    }

    BasicEngine(int movableNumber) {
        this.movableNumber = movableNumber;
    }

    @Override
    public boolean canMove(int power) {
        return power >= movableNumber;
    }
}
