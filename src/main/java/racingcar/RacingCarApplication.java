package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.PrintView;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        PrintView printView = new PrintView();

        String[] namesOfCars = inputView.getNamesOfCars();
        int numberOfTurns = inputView.getNumberOfTurns();

        RacingGame racingGame = RacingGame.withCondition(namesOfCars, numberOfTurns);
        printView.printResultTitle();
        printView.printCarStatus(racingGame.getCars());

        while (!racingGame.hasRaceEnd()) {
            racingGame.race();
            printView.printCarStatus(racingGame.getCars());
        }
        printView.printWinners(racingGame.getWinners());
    }
}
