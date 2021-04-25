package step5;

import step5.controller.RacingCarController;

public class RacingGameApplication {

    public static void main(String[] args) {
        RacingCarController controller = new RacingCarController();

        controller.init();
        controller.startGame();
        controller.findWinner();

    }
}
