package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.extension.Moveable;
import racingcar.domain.response.RacingGamePlayResponse;

public class RacingGamePlayController {

    private final Moveable moveable;

    private RacingGamePlayController() {
        throw new UnsupportedOperationException("Cannot invoke constructor \"RacingGamePlayController()\"");
    }

    public RacingGamePlayController(Moveable moveable) {
        this.moveable = moveable;
    }

    public RacingGamePlayResponse playRacingGame(int round, List<String> carNames) {
        RacingGame racingGame = new RacingGame(round, createCarsByCarNames(carNames));
        return racingGame.playAndGetRoundResults();
    }

    private List<Car> createCarsByCarNames(List<String> carNames) {
        return carNames.stream()
            .map(carName -> new Car(carName, moveable))
            .collect(Collectors.toList());
    }

}
