package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.Cars;
import racingcar.domain.CarsGenerator;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        String inputCars = inputView.inputCars();
        int tryCount = inputView.inputTryCount();
        Cars cars = CarsGenerator.generateCars(inputCars);
        ResultView resultView = new ResultView();
        RacingGameController racingGameController = new RacingGameController(cars, tryCount, resultView);
        racingGameController.process(new RandomMoveStrategy(new Random()));
    }
}
