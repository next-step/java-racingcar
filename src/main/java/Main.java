import racingcar.controller.RacingGameController;

public class Main {

    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();
        racingGameController.createRacingCars();
        racingGameController.race();
        racingGameController.findWinner();
    }
}
