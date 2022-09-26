
public class CarMoveCondition {

    private final int maxValue = 9;

    private final int minValueForMove = 4;

    public int getMaxValue() {
        return maxValue;
    }

    public boolean checkMoveCondition(int value) {
        if (value < 0 || value > maxValue) {
            throw new RuntimeException("not available value");
        }
        return value >= minValueForMove;
    }
}
