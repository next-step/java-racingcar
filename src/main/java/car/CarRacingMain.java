package car;

import car.view.InputView;
import car.view.OutputView;

public class CarRacingMain {

    public static void main(String[] args) {
        CarRacingGame game = new CarRacingGame(InputView.getCarNames());
        game.playRace(InputView.getPlayCount());
        OutputView.printWinners(game.announceWinnerNames());
    }
}
