package racingcar.controller;

import racingcar.domain.RacingCarGame;
import racingcar.dto.CarsRecord;
import racingcar.dto.RacingRecord;
import racingcar.strategy.RandomValueMovingStrategy;

public class RacingCarGameController {
    private final RacingCarGame racingCarGame;

    public RacingCarGameController(RacingCarGame racingCarGame) {
        this.racingCarGame = racingCarGame;
    }

    public RacingRecord play() {
        return racingCarGame.play(new RandomValueMovingStrategy());
    }

    public CarsRecord findFinalWinner() {
        return racingCarGame.findFinalWinner();
    }
}
