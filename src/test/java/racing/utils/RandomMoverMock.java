package racing.utils;

import com.racing.utils.RandomMover;

public class RandomMoverMock implements RandomMover {
    @Override
    public boolean shouldMove() {
        return false;
    }
}
