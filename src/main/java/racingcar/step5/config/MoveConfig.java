package racingcar.step5.config;

import racingcar.step5.domain.MovingStrategy;
import racingcar.step5.domain.RandomMoving;

public class MoveConfig {

    public MovingStrategy move() {
        return new RandomMoving();
    }

}
