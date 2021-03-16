package step3;

import step3.controller.GameController;

public class RacingCarApplication {

    public static void main(String[] args) {
        GameController controller = GameController.newInstance();
        controller.run();
    }
}
