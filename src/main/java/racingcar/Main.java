package racingcar;

import racingcar.domain.MoveStrategy;
import racingcar.domain.MoveRandomStrategy;
import racingcar.domain.RacingGame;
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
