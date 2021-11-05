package racingcar.step3;

import racingcar.step3.move.Moving;
import racingcar.step3.move.RandomMoving;

public class AppConfig {

    public Moving move() {
        return new RandomMoving();
    }

}
