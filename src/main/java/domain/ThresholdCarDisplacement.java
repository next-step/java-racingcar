package domain;

public class ThresholdCarDisplacement implements CarDisplacement{
    private final int successCount;
    private final NumberGenerator numberGenerator;

    private ThresholdCarDisplacement(NumberGenerator numberGenerator, int successCount) {
        this.numberGenerator = numberGenerator;
        this.successCount = successCount;
    }

    public static ThresholdCarDisplacement create(NumberGenerator numberGenerator, int successCount) {
        return new ThresholdCarDisplacement(numberGenerator, successCount);
    }

    @Override
    public int displacement() {
        if (numberGenerator.generate() >= successCount) {
            return Position.MOVE.getPosition();
        }
        return Position.STOP.getPosition();
    }
}
