package study.racingcar.domain;

import java.util.List;

import study.racingcar.domain.strategy.MoveStrategy;

public class RacingGame {

    private final Cars cars;
    private final TryNo tryNo;

    private int currentTryNo;

    public RacingGame(List<Name> carNames, int tryNo) {
        this.cars = Cars.fromNames(carNames);
        this.tryNo = new TryNo(tryNo);
        this.currentTryNo = 0;
    }

    public Cars playGame(MoveStrategy strategy) {
        this.currentTryNo++;
        return this.cars.racingCars(strategy);
    }

    public boolean closed() {
        return this.tryNo.value() == this.currentTryNo;
    }


    public List<Name> winners() {
        return cars.findWinner();
    }
}
