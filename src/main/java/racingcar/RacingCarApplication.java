package racingcar;

import racingcar.Contoller.RacingCarController;
import racingcar.strategy.RandomMovingStrategy;

public class RacingCarApplication {
    public static void main(String[] args) {
        new RacingCarController(new RandomMovingStrategy()).run();
    }

}
