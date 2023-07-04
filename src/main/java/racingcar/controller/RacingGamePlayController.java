package racingcar.controller;

import racingcar.controller.request.RacingGamePlayControllerRequest;
import racingcar.controller.response.RacingGamePlayControllerResponse;
import racingcar.usecase.RacingGamePlayUsecase;

public class RacingGamePlayController {

    private final RacingGamePlayUsecase racingGamePlayUsecase;

    public RacingGamePlayController(RacingGamePlayUsecase racingGamePlayUsecase) {
        this.racingGamePlayUsecase = racingGamePlayUsecase;
    }

    public RacingGamePlayControllerResponse playRacingGame(RacingGamePlayControllerRequest request) {
        return null;
    }

}
