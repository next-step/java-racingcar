package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.request.RacingGamePlayControllerRequest;
import racingcar.controller.response.RacingGamePlayControllerResponse;
import racingcar.randommove.RandomMover;
import racingcar.usecase.RacingGamePlayUsecase;
import racingcar.usecase.request.RacingGamePlayRequest;
import racingcar.usecase.request.RacingGamePlayRequest.CarRequest;

public class RacingGamePlayController {

    private final RacingGamePlayUsecase racingGamePlayUsecase;
    private static final RandomMover randomMover = RandomMover.newInstance();

    public RacingGamePlayController(RacingGamePlayUsecase racingGamePlayUsecase) {
        this.racingGamePlayUsecase = racingGamePlayUsecase;
    }

    public RacingGamePlayControllerResponse playRacingGame(RacingGamePlayControllerRequest request) {
        racingGamePlayUsecase.play(request.getRound(), getRacingGamePlayRequest(request.getCarNames()));
        return null;
    }

    private RacingGamePlayRequest getRacingGamePlayRequest(List<String> carNames) {
        return new RacingGamePlayRequest(
            carNames.stream().map(n -> new CarRequest(n, randomMover)).collect(Collectors.toList())
        );
    }

}
