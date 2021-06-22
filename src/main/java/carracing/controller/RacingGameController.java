package carracing.controller;

import carracing.model.Car;
import carracing.model.Cars;
import carracing.view.Input;
import carracing.view.Output;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {
    private static final String CAR_NAME_SEPARATOR = ",";

    public static void run() {
        Output.showInputCarName();
        Cars cars = createCars();

        Output.showInputRacingCount();
        startRacingGame(cars);

        findWinners(cars);
    }

    private static Cars createCars() {
        String carNameInput = Input.insertCarName();
        String[] carNames = carNameInput.split(CAR_NAME_SEPARATOR);
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return new Cars(carList);
    }

    private static void startRacingGame(Cars cars) {
        int gameCount = Input.insertGameCount();
        RacingGame racingGame = new RacingGame(cars, gameCount);
        racingGame.start();
    }

    private static void findWinners(Cars cars) {
        List<String> Winners = cars.makeWinners();
        Output.showWinners(Winners);
    }
}
