package racingcar;

import racingcar.controller.RaceController;

import java.io.IOException;

public final class RaceApplication {

    public static void main(final String[] args) throws IOException {
        RaceController raceController = new RaceController(new RandomMovableStrategy());
        raceController.start();
        raceController.run();
        raceController.finish();
    }
}
