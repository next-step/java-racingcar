package racingcar;

import racingcar.domain.RaceStrategy;

public class MoveRaceStrategy implements RaceStrategy {

    @Override
    public boolean decideToMove() {
        return true;
    }
}
