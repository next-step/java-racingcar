package racingcar;

import racingcar.game.RacingGame;
import racingcar.game.WinnerDecisionByBigLocations;
import racingcar.random.RandomGenerator;
import racingcar.view.ConsoleView;
import racingcar.view.NameParser;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView(new NameParser());

        int trial = consoleView.numbOfTrial();
        List<String> names = consoleView.namesOfCar();

        RacingGame racingGame = new RacingGame(
                trial,
                names,
                new RandomGenerator(0, 9));

        for (int t = 0; t < trial; t++) {
            consoleView.printCarsLocation(racingGame.runOnce());
        }

        consoleView.printWinners(racingGame.winnerCars());
    }

}

