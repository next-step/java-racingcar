
public class CarMoveCondition {

    private final int maxValue = 9;

    private final int minValueForMove = 4;

    private final IntegerGenerator integerGenerator;

    public int getMaxValue() {
        return maxValue;
    }

    public CarMoveCondition(IntegerGenerator integerGenerator) {
        this.integerGenerator = integerGenerator;
    }

    public boolean checkMoveCondition() {
        int value = integerGenerator.getValue();
        if (value < 0 || value > maxValue) {
            throw new RuntimeException("not available value");
        }
        return value >= minValueForMove;
    }
}
