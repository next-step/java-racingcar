package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
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

    public RacingGamePlayResponse playRacingGame(int round, List<String> carNames) {
        RacingGame racingGame = new RacingGame(round, createCarsByCarNames(carNames));
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
