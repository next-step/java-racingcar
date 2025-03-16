package step3.racingcar.controller;

public class RacingCarGameController {

    public static void main(String[] args) {

        RacingCarGameSetController gameSetController = new RacingCarGameSetController();

        gameReady(gameSetController);
        gameStart(gameSetController);
    }

    public static void gameReady(RacingCarGameSetController gameSetController) {
        gameSetController.setReady();
    }

    public static void gameStart(RacingCarGameSetController gameSetController) {
        gameSetController.setStart();
    }

}
