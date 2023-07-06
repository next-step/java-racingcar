package racing.controller;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import racing.io.GameViewer;
import racing.model.Cars;

public class GameController {

    private final GameViewer viewer;

    public GameController(final GameViewer viewer) {
        this.viewer = viewer;
    }

    public void startRacing(final Cars cars, final int tryCount) {
        viewer.printBeforeRacing(cars);
        race(cars, tryCount);
        final List<String> winnerNames = cars.findWinnerNames();
        viewer.printWinners(winnerNames);
    }

    private void race(final Cars cars, int tryCount) {
        while (tryCount-- > 0) {
            cars.moveCars(ThreadLocalRandom.current());
            viewer.printCars(cars);
        }
    }
}
