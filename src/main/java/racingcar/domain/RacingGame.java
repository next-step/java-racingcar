package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.movingcondition.MovingCondition;

public class RacingGame {
    private final Cars cars;
    private final MovingCondition movingCondition;
    private int remainPlayCount;

    public RacingGame(Cars cars, MovingCondition movingCondition, int playCount) {
        this.cars = cars;
        this.movingCondition = movingCondition;
        this.remainPlayCount = playCount;
    }

    public boolean isGameEnd() {
        return remainPlayCount <= 0;
    }

    public RoundResult play() {
        if (isGameEnd()) {
            throw new RuntimeException("이미 종료된 게임입니다.");
        }

        return playNextRound();
    }

    public List<CarStat> findWinners() {
        return cars.findWinners();
    }

    private RoundResult playNextRound() {
        remainPlayCount--;
        return new RoundResult(cars.move(movingCondition));
    }
}
