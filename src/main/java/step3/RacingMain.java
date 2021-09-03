package step3;

import step3.controller.RacingController;

public class RacingMain {
    public static void main(String[] args) {
        RacingController controller = new RacingController();
        controller.initGame();
        controller.startRace();
        controller.getWinner();
    }
}
