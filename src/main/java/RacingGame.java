import racingcar.controller.RacingGameController;
import racingcar.controller.RacingGameControllerImpl;

public class RacingGame {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameControllerImpl();

        racingGameController.initialize();
        racingGameController.play();
        racingGameController.showResult();
    }
}