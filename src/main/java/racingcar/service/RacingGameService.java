package racingcar.service;

import racingcar.domain.RacingCars;

import java.util.List;

public class RacingGameService {

    private RacingCars cars;
    private int tryCount;

    private RacingGameService(List<String> carName, int tryCount) {

        cars = RacingCars.racingGameReady(carName);
        this.tryCount = tryCount;
    }

    public static RacingGameService ready(List<String> carName, int tryCount) {

        return new RacingGameService(carName,tryCount);
    }

    public void race() {
        if(tryCount < 1) {
            throw new IllegalArgumentException("0 이하 값은 불가능 합니다.");
        }
        RacingCars.playTheGame(cars);
        tryCount--;
    }

    public boolean isEndGame() {
        return tryCount == 0;
    }

    public RacingCars getCars() {
        return cars;
    }
}
