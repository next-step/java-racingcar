package carracing.controller;

import carracing.model.Car;
import carracing.model.CarStrategy;
import carracing.model.Cars;
import carracing.view.Output;

public class RacingGame {
    private static final int RACING_COUNT_FIRST_INDEX = 0;

    private Cars cars;
    private int gameCount;

    public RacingGame(Cars cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public void start() {
        cars.setCarStrategy(new CarStrategy());
        for (int i = RACING_COUNT_FIRST_INDEX; i < gameCount; i++) {
            cars.moveCars();
            for (Car car : cars.getCars()) {
                Output.showCarStatus(car);
            }
            Output.breakNewLine();
        }
    }
}
