package domain.strategy;

import domain.MoveStrategy;
import domain.RacingCar;
import util.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean isMovable() {
        return RacingCar.getStandardMoveCount() >= RandomNumberGenerator.generateRandomNumber();
    }
}
