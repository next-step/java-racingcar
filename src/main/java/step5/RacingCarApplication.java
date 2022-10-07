package step5;

import step5.controller.RacingGameController;
import step5.domain.RandomNumberStrategy;

public class RacingCarApplication {

    public static void main(String[] args) {
        RacingCarApplication.run();
    }

    public static void run() {
        new RacingGameController(new RandomNumberStrategy()).play();
    }
}
