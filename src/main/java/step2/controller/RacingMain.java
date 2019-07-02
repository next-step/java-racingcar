package step2.controller;

import step2.model.Car;
import step2.model.RacingGame;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingMain {

    public static void main(String[] arg) {
        String inputCarNumber = InputView.inputCarNames();
        int inputExecuteNumber = InputView.inputExecuteNumber();

        List<Car> cars = null;
        RacingGame racingGame = new RacingGame(createCars(inputCarNumber));
        while (inputExecuteNumber > 0) {
            cars = racingGame.move();
            OutputView.racingResult(cars);
            inputExecuteNumber--;
        }
        OutputView.racingWinnerResult(cars);
    }

    private static List<Car> createCars(String inputCarNames){
        List<String> carNames = Arrays.asList(inputCarNames.split(","));
        return carNames.stream()
                       .map(Car::new)
                       .collect(Collectors.toList());
    }

}
