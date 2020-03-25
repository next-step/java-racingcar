package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RacingGameSetting;
import racingcar.domain.Round;
import racingcar.policy.RandomMovingPolicy;

public class RacingGame {
    private final RacingGameSetting setting;
    private Round round;

    public RacingGame(final RacingGameSetting racingGameSetting) {
        this.setting = racingGameSetting;
        this.round = new Round();
    }

    public void play() {
        moveCars();
        round = round.next();
    }

    public Cars getCars() {
        return setting.getCars();
    }

    public boolean isGameOver() {
        return round.isEnd(setting.getTime());
    }

    private void moveCars() {
        getCars().move(new RandomMovingPolicy());
    }
}
