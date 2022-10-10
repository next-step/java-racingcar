package RacingCar;

import RacingCar.domain.MovingStrategy;

public class StopMovingStrategy implements MovingStrategy {
    @Override
    public int moveable(int range) {
        return 3;
    }
}
