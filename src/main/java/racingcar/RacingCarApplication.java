package racingcar;

import racingcar.application.RacingService;
import racingcar.console.RacingConsole;

public class RacingCarApplication {
    public static void main(final String[] args) {
        RacingConsole.run(new RacingService());
    }
}
