package car;

import car.view.InputView;
import car.view.OutputView;

public class CarRacingMain {

    public static void main(String[] args) {
        CarRacingGame game = new CarRacingGame(InputView.getCarNames(), InputView.getPlayCount());

        OutputView.startPrintingResult();
        while (game.isNotFinished()) {
            game.playRaceOnce();
            OutputView.printCurrentStatus(game);
        }
        OutputView.printWinners(game);
    }
}
