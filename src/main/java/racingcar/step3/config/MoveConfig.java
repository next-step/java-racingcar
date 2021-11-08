package racingcar.step3.config;

import racingcar.step3.move.Moving;
import racingcar.step3.move.RandomMoving;

public class MoveConfig {

    public Moving move() {
        return new RandomMoving();
    }

}
