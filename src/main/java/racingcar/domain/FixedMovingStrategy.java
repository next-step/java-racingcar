package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class FixedMovingStrategy implements MovingStrategy {

    private int currentIdx;

    private List<Boolean> movingResult = new ArrayList<>();

    public FixedMovingStrategy(int movableCount, int notMovableCount) {
        createMovableInOrder(movableCount);
        createNotMovableInOrder(notMovableCount);
    }

    private void createMovableInOrder(int movableCount) {
        for (int i = 0; i < movableCount; i++) {
            this.movingResult.add(Boolean.TRUE);
        }
    }

    private void createNotMovableInOrder(int notMovableCount) {
        for (int i = 0; i < notMovableCount; i++) {
            this.movingResult.add(Boolean.FALSE);
        }
    }

    @Override
    public boolean isMovable() {
        Boolean result = movingResult.get(currentIdx);
        currentIdx++;
        return result;
    }
}
