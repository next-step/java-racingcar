package step3;

import step3.domain.RacingGame;
import step3.view.InputView;

public class RacingMain {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();
        racingGameController.racingStart();
        racingGameController.printRacingWithName();
        racingGameController.printWinner();
    }
}
