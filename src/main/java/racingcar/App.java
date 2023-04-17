package racingcar;

import racingcar.view.ConsoleView;
import racingcar.view.ToStringsParser;

public class App {
    public static void main(String[] args) {
        RacingGame racingGame =
                new RacingGame(
                        new ConsoleView(new ToStringsParser()),
                        new RandomGenerator(0, 9));

        racingGame.run();
    }
}
