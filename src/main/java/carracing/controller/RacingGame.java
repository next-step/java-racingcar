package carracing.controller;

import carracing.model.Car;
import carracing.model.Cars;
import carracing.view.Input;
import carracing.view.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {
    private static final String CAR_NAME_SEPARATOR = ",";
    private static final int RACING_COUNT_FIRST_INDEX = 0;

    public static void run() {
        Output.showInputCarName();
        String carNameInput = Input.insertCarName();

        List<String> CarNames = Arrays.asList(carNameInput.split(CAR_NAME_SEPARATOR));
        List<Car> carList = new ArrayList<>();
        for (String carName : CarNames) {
            carList.add(new Car(carName));
        }

        Output.showInputRacingCount();
        int gameCount = Input.insertGameCount();
        Cars cars = new Cars(carList);
        for (int i = RACING_COUNT_FIRST_INDEX; i < gameCount; i++) {
            for (Car car : cars.getCars()) {
                cars.moveCars(car);
                Output.showCarStatus(car);
            }
            Output.breakNewLine();
        }
        Output.showWinners(cars);
    }
}
