package step3.controller;

import step3.domain.Car;
import step3.service.GameService;
import step3.service.RandomGameService;
import step3.view.InputView;
import step3.view.ResultView;

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
