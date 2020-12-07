package racingcar.service;

import racingcar.domain.MoveRule;

public class RacingGameStub extends RacingGame {

    public RacingGameStub(int countOfCar, int countOfRound) {
        super(countOfCar, countOfRound);
    }

    @Override
    public MoveRule adjustRule() {
        return () -> true;
    }

}
