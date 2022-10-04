package racingcar;

import java.util.Collections;

import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.view.GameInputView;
import racingcar.view.GameOutputView;

public class CarRacingGame {
    private static final Cars NOT_EXIST = new Cars(Collections.emptyList());
    
    private final GameInputView input;
    private final GameOutputView output;

    public CarRacingGame(GameInputView input, GameOutputView output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        Cars cars = NOT_EXIST;
        Racing racing = input.racing();
        while (!racing.isFinish()) {
            cars = racing.race();
            output.show(cars);
        }
        output.showFinish(cars);
    }
}
