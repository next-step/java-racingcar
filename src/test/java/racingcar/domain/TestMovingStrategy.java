package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.strategy.MovingStrategy;

public class TestMovingStrategy implements MovingStrategy {

    private final List<Integer> returnPositions = new ArrayList<>();

    public TestMovingStrategy(final int count) {
        for (int i = 0; i < count; i++) {
            returnPositions.add(i);
        }
    }

    @Override
    public int move() {
        int position = returnPositions.get(0);
        returnPositions.remove(0);

        return position;
    }
}
