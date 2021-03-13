package racingcar.module;

import racingcar.model.Cars;

public class RacingGame {
    private RacingRound racingRound;

    public RacingRound startGame(Cars cars, int tryNum) {
        racingRound = new RacingRound();
        for (int num = 0; num < tryNum; num++) {
            cars.playCarGame();
            racingRound.insertResult(cars, num);
        }

        return racingRound;
    }

}
