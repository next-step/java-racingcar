package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.request.RacingGamePlayControllerRequest;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.extension.Moveable;
import racingcar.domain.response.RacingGamePlayResponse;
import racingcar.randommove.RandomMover;

public class RacingGamePlayController {

    private static final Moveable randomMover = RandomMover.newInstance();

    private RacingGamePlayController() {
    }

    public static RacingGamePlayController getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public RacingGamePlayResponse playRacingGame(RacingGamePlayControllerRequest request) {
        RacingGame racingGame = new RacingGame(request.getRound(), createCarsByCarNames(request.getCarNames()));
        return racingGame.playAndGetRoundResults();
    }

    private List<Car> createCarsByCarNames(List<String> carNames) {
        return carNames.stream()
            .map(carName -> new Car(carName, randomMover))
            .collect(Collectors.toList());
    }

    private static final class SingletonHelper {

        private static final RacingGamePlayController INSTANCE = new RacingGamePlayController();

    }

}
