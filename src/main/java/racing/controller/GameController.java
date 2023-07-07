package racing.controller;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import racing.io.GameViewer;
import racing.model.Cars;
import racing.model.GameReadyInfo;

public class GameController {

    private final GameViewer viewer;

    public GameController(final GameViewer viewer) {
        this.viewer = viewer;
    }

    public void startRacing(final GameReadyInfo gameReadyInfo) {
        final Cars cars = gameReadyInfo.getCars();
        final int tryCount = gameReadyInfo.getTryCount();

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
