package racingcar;

import racingcar.view.ConsoleRacingCarView;

public class RacingGameApplication {
    public static void main(String[] args) {
        new RacingGameRunner(new ConsoleRacingCarView()).run();
    }
}
