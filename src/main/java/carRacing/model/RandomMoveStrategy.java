package carRacing.model;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int STANDARD_NUMBER = 4;
    private final RandomGenerator randomGenerator;

    public RandomMoveStrategy(RandomGenerator randomGenerator){
        this.randomGenerator = randomGenerator;
    }

    @Override
    public boolean isMove() {
        return randomGenerator.randomNum() >= STANDARD_NUMBER;
    }

}
