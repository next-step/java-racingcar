package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.car.Cars;
import racingcar.view.input.RacingCarParameter;

import java.util.List;

public class RacingCarController {

    public List<Cars> getRacingCarResult(RacingCarParameter parameter) {
        RacingGame racingGame = new RacingGame(parameter.getCarNames(), parameter.getRacingCount());
        return racingGame.getRacingGameResult();
    }

}
