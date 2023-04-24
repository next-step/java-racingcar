package racingcar;

import racingcar.view.ConsoleView;
import racingcar.view.NameParser;

public class App {
    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView(new NameParser());
        RacingGame racingGame = new RacingGame(
                consoleView.numbOfTrial(),
                consoleView.namesOfCar(),
                new WinnerDecisionByBigLocations());

        racingGame.run();

        consoleView.printCarsLocation(racingGame.allCars());
        consoleView.printWinners(racingGame.winners());
    }
}

