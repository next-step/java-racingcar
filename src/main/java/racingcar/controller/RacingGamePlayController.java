package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.extension.input.Inputable;
import racingcar.controller.extension.view.Viewable;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.extension.Moveable;
import racingcar.domain.response.RacingGamePlayResponse;

public class RacingGamePlayController {

    private final Moveable moveable;

    private RacingGamePlayController() {
        throw new UnsupportedOperationException("Cannot invoke constructor \"RacingGamePlayController()\"");
    }

    public RacingGamePlayController(Inputable inputable, Viewable viewable, Moveable moveable) {
        this.moveable = moveable;
    }

    public RacingGamePlayResponse playRacingGame() {
        RacingGame racingGame = new RacingGame(0, createCarsByCarNames(List.of()));
        return racingGame.playAndGetRoundResults();
    }

    private List<Car> createCarsByCarNames(List<String> carNames) {
        return carNames.stream()
            .map(carName -> new Car(carName, moveable))
            .collect(Collectors.toList());
    }

}
