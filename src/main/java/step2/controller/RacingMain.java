package step2.controller;

import step2.model.Car;
import step2.model.Cars;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingMain {

    public static void main(String[] arg) {
        String inputCarNames = InputView.inputCarNames();
        int inputExecuteNumber = InputView.inputExecuteNumber();

        Cars cars = new Cars(createCars(inputCarNames));
        while (inputExecuteNumber > 0) {
            cars.move();
            OutputView.racingResult(cars);
            inputExecuteNumber--;
        }
        OutputView.racingWinnerResult(cars);
    }

    private static List<Car> createCars(String carName){
        List<String> carNames = Arrays.asList(carName.split(","));
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

}
