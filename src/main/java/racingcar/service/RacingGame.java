package racingcar.service;

import racingcar.domain.Cars;

public class RacingGame {
    private RacingRound racingRound;

    public RacingRound startGame(Cars cars, int tryNum) {
        racingRound = new RacingRound();
        for (int num = 0; num < tryNum; num++) {
            cars.playCarGame();
            racingRound.insertResult(cars.copyCars(), num);
        }
        return racingRound;
    }
}
