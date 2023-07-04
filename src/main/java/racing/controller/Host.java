package racing.controller;

import racing.factory.CarFactory;
import racing.io.Viewer;
import racing.manager.RacingManager;
import racing.model.Cars;
import racing.model.GameInfo;

public class Host {

    private final int raceCount;
    private final RacingManager racingManager;
    private final Viewer viewer;

    public Host(GameInfo gameInfo, CarFactory carFactory, Viewer viewer) {
        this.raceCount = gameInfo.getRaceCount();

        Cars cars = new Cars(
                carFactory.manufactureCars(gameInfo.getCarNames())
        );
        this.racingManager = new RacingManager(cars);
        this.viewer = viewer;
    }

    public void startRacing() {
        viewer.printBeforeRacing(
                racingManager.getCars()
        );

        for (int i = 0; i < raceCount; i++) {
            viewer.printCars(
                    racingManager.turn()
            );
        }

        viewer.printWinners(
                racingManager.getWinnerNames()
        );
    }

}
