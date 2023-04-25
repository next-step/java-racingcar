package racingcar;

import racingcar.game.RacingGame;
import racingcar.game.WinnerDecisionByBigLocations;
import racingcar.view.ConsoleView;
import racingcar.view.NameParser;

public class App {
    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView(new NameParser());
        RacingGame racingGame = new RacingGame(
                consoleView.numbOfTrial(),
                consoleView.namesOfCar(),
                new WinnerDecisionByBigLocations());

        racingGame.runOnce();

        consoleView.printCarsLocation(racingGame.allCars());
        consoleView.printWinners(racingGame.winnerCars());
    }
}

