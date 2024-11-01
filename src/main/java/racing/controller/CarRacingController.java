package racing.controller;

import racing.entity.Car;
import racing.service.Cars;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

public class CarRacingController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<Car> carList = inputView.inputCar();
        int rounds = inputView.inputNumber();

        Cars cars = new Cars(carList);
        ResultView resultView = new ResultView();

        for (int i = 0; i < rounds; i++) {
            cars.moveCars();
            resultView.printResult(cars.getCars());
        }
        resultView.findWinners(cars.findWinners());
    }

}
