package racing_game.domain;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int THRESHOLD = 4;
    private final RandomGenerator randomGenerator;

    public RandomMovingStrategy(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public boolean canMove() {
        return randomGenerator.getRandomValue() >= THRESHOLD;
    }
}
