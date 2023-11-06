package racinggame.domain.strategy;

public class RandomMovingStrategy implements MovingStrategy{

    public static final int MIN_MOVABLE_NUMBER = 3;

    private final RandomHolder randomHolder;

    public RandomMovingStrategy(RandomHolder randomHolder) {
        this.randomHolder = randomHolder;
    }

    @Override
    public boolean movable() {
        return randomHolder.nextInt() > MIN_MOVABLE_NUMBER;
    }

}
