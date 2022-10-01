package racingcar;

import racingcar.domain.CarRacing;
import racingcar.view.GameInputView;
import racingcar.view.GameOutputView;

public class CarRacingGame {
    private final GameInputView input;
    private final GameOutputView output;

    public CarRacingGame(GameInputView input, GameOutputView output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        new CarRacing(input.racing(), output).race();
    }
}
