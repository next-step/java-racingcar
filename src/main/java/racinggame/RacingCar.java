package racinggame;

import racinggame.exception.RacingGameException;
import racinggame.input.RacingTryCountInput;

import java.util.ArrayList;
import java.util.List;

import static racinggame.utils.RacingGameConstant.MOVE_THRESHOLD;

public class RacingCar {
    private final RacingTryCountInput tryLimit;
    private final List<Boolean> histories;

    public RacingCar(final RacingTryCountInput tryCountInput) {
        this.tryLimit = tryCountInput;
        this.histories = new ArrayList<>();
    }

    public boolean isMove(final int moveCondition) {
        if (tryLimit.getTrials() <= histories.size()) {
            throw new RacingGameException("더 이상 이동 할 수 없습니다.");
        }

        final boolean isMoved = moveCondition > MOVE_THRESHOLD;
        histories.add(isMoved);
        return isMoved;
    }

    public List<Boolean> currentHistories() {
        return this.histories;
    }
}
