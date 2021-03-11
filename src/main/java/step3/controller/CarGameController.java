package step3.controller;

import step3.domain.Car;
import step3.service.GameService;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class CarGameController {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();
    GameService gameService = new GameService();


    public void run() {
        Integer carNumber = inputView.getCarNumber();
        Integer stepNumber = inputView.getStepNumber();
        List<Car> cars = gameService.generateCar(carNumber);
        resultView.printStart();
        for (Integer i = 0; i < stepNumber; i++) {
            gameService.runStep(cars);
            resultView.printLocationView(cars);
            System.out.println();
        }
    }
}
