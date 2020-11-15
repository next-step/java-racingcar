import racingcar.controller.RacingGameController;

public class Main {

    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();
        racingGameController.run();
        racingGameController.startRacingGame();
        racingGameController.race();
        racingGameController.findWinner();
    }
}
