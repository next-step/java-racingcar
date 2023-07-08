package racing.controller;

import racing.factory.CarFactory;
import racing.io.Viewer;
//import racing.manager.RacingManager;
import racing.model.Cars;
import racing.model.GameInfo;

public class GameController {

    private final CarFactory carFactory;
    private final Viewer viewer;

    public GameController(CarFactory carFactory, Viewer viewer) {
        this.carFactory = carFactory;
        this.viewer = viewer;
    }

    public void startRacing(final GameInfo gameInfo) {
        Cars cars = new Cars(this.carFactory.manufactureCars(gameInfo.getCarNames()));

        viewer.printBeforeRacing(cars);

        for (int i = 0; i < gameInfo.getRaceCount(); i++) {
            cars.moveCars();
            viewer.printCars(cars);
        }

        viewer.printWinners(cars.findWinnerNames());
    }

}
