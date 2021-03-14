package RacingCar.controller;

import RacingCar.domain.Car;
import RacingCar.service.GameService;
import RacingCar.service.RandomGameService;
import RacingCar.view.InputView;
import RacingCar.view.ResultView;

import java.util.List;

public class CarGameController {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();
    GameService gameService = new RandomGameService();


    public void run() {
        int carNumber = inputView.getCarNumber();
        int stepNumber = inputView.getStepNumber();
        int nowStep = 0;


        List<Car> cars = gameService.generateCar(carNumber);
        resultView.printStart();
        for (; nowStep < stepNumber; nowStep++) {
            gameService.runStep(cars);
            resultView.printLocationView(cars);
            System.out.println();
        }
    }
}
