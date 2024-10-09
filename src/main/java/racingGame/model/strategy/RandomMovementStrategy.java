package racingGame.model.strategy;

import racingGame.model.numbergenerator.NumberGenerator;
import racingGame.model.numbergenerator.RandomNumberGenerator;

public class RandomMovementStrategy implements MovementStrategy{

    private static final int MINIMUM_MOVEMENT_VALUE = 4;

    private static final NumberGenerator numberGenerator = new RandomNumberGenerator();

    public RandomMovementStrategy() {};

    @Override
    public boolean isMovable() {
        return numberGenerator.generateNumber() >= MINIMUM_MOVEMENT_VALUE;
    }
}
