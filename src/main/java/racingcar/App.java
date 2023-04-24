package racingcar;

import racingcar.view.ConsoleView;
import racingcar.view.NameParser;

public class App {
    public static void main(String[] args) {
        RacingGame racingGame =
                new RacingGame(
                        new ConsoleView(new NameParser()),
                        new WinnerDecisionByBigLocations());

        racingGame.run();
    }
}

