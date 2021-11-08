package step3;

public class RandomMoveStrategy implements MoveStrategy {

    private final int moveCondition;
    private final NumberGenerator numberGenerator;

    public RandomMoveStrategy(int moveCondition, NumberGenerator numberGenerator) {
        this.moveCondition = moveCondition;
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean test() {
        return numberGenerator.generate() >= moveCondition;
    }
}
