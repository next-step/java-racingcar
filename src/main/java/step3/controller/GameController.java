package step3.controller;

import step3.domain.Car;
import step3.service.GameService;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private GameService gameService;
    private List<Car> cars;

    private GameController() {
        this.gameService = GameService.newInstance();
        this.cars = new ArrayList<>();
    }

    public static GameController newInstance() {
        return new GameController();
    }

    public void run() {
        makeCars();
        moveCars();
    }

    private void makeCars() {
        int countOfCars = InputView.getCountOfCars();
        this.cars = gameService.makeCars(countOfCars);
    }

    private void moveCars() {
        int countOfTry = InputView.getCountOfTry();
        for (int i = 0; i < countOfTry; i++) {
            this.cars = gameService.moveCars(cars);
        }
    }
}
