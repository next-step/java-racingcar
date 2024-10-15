package racing.utils;

import com.racing.utils.RandomStrategy;

public class RandomStrategyMock implements RandomStrategy {
    @Override
    public boolean shouldMove() {
        return false;
    }
}
