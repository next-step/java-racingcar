package racing.utils;

import com.racing.utils.MovementStrategy;

public class RandomStrategyMock implements MovementStrategy {
    @Override
    public boolean shouldMove() {
        return false;
    }
}
