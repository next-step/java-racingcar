package study.racingcar.domain;

import java.util.List;

import study.racingcar.GamePlay;
import study.racingcar.domain.strategy.MoveStrategy;

public class RacingGame {

    private final Cars cars;
    private final int tryNo;

    private int currentTryNo;

    public RacingGame(List<Name> carNames, int tryNo) {
        this.cars = Cars.fromNames(carNames);
        this.tryNo = tryNo;
        this.currentTryNo = 0;
    }

    public Cars race(MoveStrategy strategy) {
        this.currentTryNo++;
        return this.cars.goRace(strategy);
    }

    public boolean isEnd() {
        return this.tryNo == this.currentTryNo;
    }


    public List<Name> findWinners() {
        return cars.findWinner();
    }
}
