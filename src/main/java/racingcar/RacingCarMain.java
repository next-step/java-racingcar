package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.RandomValueMovingStrategy;

public class RacingCarMain {

    public static void main(String[] args) {
        RacingCarController controller = new RacingCarController();
        controller.run(new RandomValueMovingStrategy());
    }

}
