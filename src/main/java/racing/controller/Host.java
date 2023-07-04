package racing.controller;

import racing.factory.CarFactory;
import racing.manager.RacingManager;
import racing.io.Viewer;
import racing.model.GameInfo;

public class Host {

    private final int raceCount;
    private final RacingManager racingManager;
    private final Viewer viewer;

    public Host(GameInfo gameInfo, CarFactory carFactory, Viewer viewer) {
        this.raceCount = gameInfo.getRaceCount();
        this.racingManager = new RacingManager(
                carFactory.manufactureCars(gameInfo.getCarNames())
        );
        this.viewer = viewer;
    }

    public void startRacing() {
        viewer.printBeforeRacing(
                racingManager.getCarClones()
        );

        for (int i = 0; i < raceCount; i++) {
            viewer.printCars(
                    racingManager.turn()
            );
        }

        viewer.printWinners(
                racingManager.checkWinners()
        );
    }

}
