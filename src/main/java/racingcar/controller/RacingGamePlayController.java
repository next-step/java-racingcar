package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.request.RacingGamePlayControllerRequest;
import racingcar.controller.response.RacingGamePlayControllerResponse;
import racingcar.randommove.RandomMover;
import racingcar.usecase.RacingGamePlayUsecase;
import racingcar.usecase.RacingGamePlayable;
import racingcar.usecase.request.RacingGamePlayRequest;
import racingcar.usecase.request.RacingGamePlayRequest.CarRequest;
import racingcar.usecase.response.RacingGamePlayResponse;

public class RacingGamePlayController {

    private final RacingGamePlayable racingGamePlayable;
    private static final RandomMover randomMover = RandomMover.newInstance();

    public RacingGamePlayController(RacingGamePlayUsecase racingGamePlayUsecase) {
        this.racingGamePlayable = racingGamePlayUsecase;
    }

    public RacingGamePlayControllerResponse playRacingGame(RacingGamePlayControllerRequest request) {
        RacingGamePlayResponse playResult = racingGamePlayable
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
