package study.racing;

import study.racing.controller.RacingController;
import study.racing.domain.RandomGenerator;
import study.racing.view.InputView;
import study.racing.view.OutputView;

import java.util.Random;

public class RacingApplication {

    public static void main(String[] args) {
        RacingController controller = new RacingController(
                new OutputView(),
                new InputView(),
                new RandomGenerator(new Random())
        );

        controller.startGame();
    }
}
