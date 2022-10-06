package racingGame;

import racingGame.domain.Car;
import racingGame.domain.Cars;
import racingGame.domain.InputValue;
import racingGame.factory.CarFactory;
import racingGame.view.InputView;
import racingGame.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    private final InputView inputView;
    private final ResultView resultView;
    private final CarFactory carFactory;

    public RacingGame(InputView inputView, ResultView resultView, CarFactory carFactory) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.carFactory = carFactory;
    }


    public void play() {
        InputValue inputValue = inputView.askInput(new Scanner(System.in));
        Cars cars = createCars();
        cars.addNewCar(inputValue, carFactory);
        resultView.printRacingResult(cars, inputValue.getTryNum());
    }

    private Cars createCars() {
        return new Cars();
    }

}
