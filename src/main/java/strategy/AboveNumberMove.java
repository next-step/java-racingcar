package strategy;

public class AboveNumberMove implements MovableStrategy {

    private final int movableNumber;
    private final NumberGeneratorStrategy movableStrategy;

    public AboveNumberMove(int movableNumber, NumberGeneratorStrategy movableStrategy) {
        this.movableNumber = movableNumber;
        this.movableStrategy = movableStrategy;
    }

    @Override
    public boolean move() {
        return movableStrategy.generate() >= movableNumber;
    }
}
