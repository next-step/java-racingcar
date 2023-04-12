package racingcar;

import racingcar.view.ConsoleView;

public class App {
    public static void main(String[] args) {
        RacingGame racingGame =
                new RacingGame(new ConsoleView(), new RandomGenerator(0, 9));

        racingGame.run();
    }
}
