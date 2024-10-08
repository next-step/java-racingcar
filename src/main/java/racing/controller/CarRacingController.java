package racing.controller;

import racing.entity.Car;
import racing.service.CarRacingService;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

public class CarRacingController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<Car> cars = inputView.inputCar();
        int rounds = inputView.inputNumber();

        CarRacingService racingService = new CarRacingService(cars);
        ResultView resultView = new ResultView();

        for (int i = 0; i < rounds; i++) {
            racingService.moveCars();
            resultView.printResult(racingService.getCars());
        }
    }
}

