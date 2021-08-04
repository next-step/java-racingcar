package racingcar;

import racingcar.domain.RaceStrategy;

public class NotMoveRaceStrategy implements RaceStrategy {
    @Override
    public boolean decideToMove() {
        return false;
    }
}
