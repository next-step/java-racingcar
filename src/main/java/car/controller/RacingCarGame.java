package car.controller;

import car.dto.Car;
import car.service.InputType;
import car.service.Movement;
import car.service.RandomMoveStrategy;
import car.service.WinnerCalculator;
import car.view.InputView;
import car.view.ResultView;

import java.util.*;

public class RacingCarGame {
    private static final String PRINT_FORMAT = "-";

    public static void main(String[] args) {
        String[] carNames = InputView.getStringInput(InputType.CAR_NAME);
        int tryCount = InputView.getNumberInput(InputType.TRY_COUNT);

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        Movement movement = new Movement(cars, new RandomMoveStrategy());

        for (int i = 0; i < tryCount; i++) {
            movement.moveCars();
            ResultView.printRaceResult(cars, PRINT_FORMAT);
        }
        List<Car> winners = WinnerCalculator.getWinners(cars);
        ResultView.printWinner(winners);
    }
}
