package racingcar;

import racingcar.service.MoveStrategy;
import racingcar.service.MoveRandomStrategy;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {
        ResultView.printNameOfCars();
        String nameOfCars = InputView.inputNameOfCars();

        ResultView.printNumberOfMovements();
        int movements = InputView.inputNumberOfMovements();

        MoveStrategy moveStrategy = new MoveRandomStrategy();
        RacingGame racingGame = new RacingGame(nameOfCars, moveStrategy);

        ResultView.printRacingResult();
        for (int i = 0; i < movements; i++) {
            racingGame.start();
            ResultView.printStatusOfCars(racingGame.getRacingCars());
        }

        ResultView.printWinners(racingGame.getWinner());
    }
}
