package racingcar.step4.config;

import racingcar.step4.move.Moving;
import racingcar.step4.move.RandomMoving;

public class MoveConfig {

    public Moving move() {
        return new RandomMoving();
    }

}
