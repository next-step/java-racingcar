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
    private final Inputable inputable;
    private final Viewable viewable;

    private RacingGamePlayController() {
        throw new UnsupportedOperationException("Cannot invoke constructor \"RacingGamePlayController()\"");
    }

    public RacingGamePlayController(Inputable inputable, Viewable viewable, Moveable moveable) {
        this.inputable = inputable;
        this.viewable = viewable;
        this.moveable = moveable;
    }

    public void playRacingGame() {
        RacingGame racingGame = new RacingGame(inputable.inputRound(), createCarsByCarNames(inputable.inputCarNames()));

        RacingGamePlayResponse racingGamePlayResponse = racingGame.playAndGetRoundResults();

        viewable.draw(racingGamePlayResponse);
    }

    private List<Car> createCarsByCarNames(List<String> carNames) {
        return carNames.stream()
            .map(carName -> new Car(carName, moveable))
            .collect(Collectors.toList());
    }

}
