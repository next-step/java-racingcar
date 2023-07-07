package racingcar;

import racingcar.controller.RaceController;

import java.io.IOException;

public final class RaceApplication {

    private static final RaceController raceController = new RaceController(new RandomNumberGenerator());

    public static void main(final String[] args) throws IOException {
        raceController.start();
        raceController.run();
        raceController.finish();
    }
}
