package racingcar;

import racingcar.view.ConsoleRacingView;

public class RacingGameApplication {
    public static void main(String[] args) {
        new RacingGameRunner(new ConsoleRacingView()).run();
    }
}
