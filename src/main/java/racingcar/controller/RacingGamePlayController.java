package racingcar.controller;

import racingcar.controller.request.RacingGamePlayControllerRequest;
import racingcar.controller.response.RacingGamePlayControllerResponse;
import racingcar.domain.move.RandomMover;
import racingcar.usecase.RacingGamePlayUsecase;
import racingcar.usecase.request.RacingGamePlayRequest;
import racingcar.usecase.request.RacingGamePlayRequest.CarRequest;
import racingcar.usecase.response.RacingGamePlayResponse;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGamePlayController {

    private final RacingGamePlayUsecase racingGamePlayUsecase;
    private static final RandomMover randomMover = RandomMover.getInstance();

    public RacingGamePlayController(RacingGamePlayUsecase racingGamePlayUsecase) {
        this.racingGamePlayUsecase = racingGamePlayUsecase;
    }

    public RacingGamePlayControllerResponse playRacingGame(RacingGamePlayControllerRequest request) {
        RacingGamePlayResponse playResult = racingGamePlayUsecase
            .play(request.getRound(), getRacingGamePlayRequest(request.getCarNames()));

        return new RacingGamePlayControllerResponse(playResult);
    }

    private RacingGamePlayRequest getRacingGamePlayRequest(List<String> carNames) {
        return new RacingGamePlayRequest(
            carNames.stream()
                .map(n -> new CarRequest(n, randomMover))
                .collect(Collectors.toList())
        );
    }

}
