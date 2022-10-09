package racingcar;

import java.util.Collections;

import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.domain.moving.MovingStrategy;
import racingcar.view.GameInputView;
import racingcar.view.GameOutputView;

public class CarRacingGame {
    private static final Cars NOT_EXIST = new Cars(Collections.emptyList());
    
    private final GameInputView input;
    private final GameOutputView output;
    private final MovingStrategy movingStrategy;

    public CarRacingGame(GameInputView input, GameOutputView output, MovingStrategy movingStrategy) {
        this.input = input;
        this.output = output;
        this.movingStrategy = movingStrategy;
    }

    public void start() {
        Cars cars = NOT_EXIST;
        Racing racing = input.racing();
        while (!racing.isFinish()) {
            cars = racing.race(movingStrategy);
            output.show(cars);
        }
        output.showFinish(cars);
    }
}
