package car.controller;

import car.domain.CarRacingGame;
import car.view.InputView;
import car.view.OutputView;

public class CarRacingController {

    public static void playGame(String[] args) {
        final CarRacingGame game = new CarRacingGame(InputView.getCarNames(), InputView.getPlayCount());

        OutputView.startPrintingResult();
        while (game.isNotFinished()) {
            game.playRaceOnce();
            OutputView.printCurrentStatus(game);
        }
        OutputView.printWinners(game);
    }
}
