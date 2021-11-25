package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.service.CarsService;
import racingcar.strategy.MovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Game {
    private MovingStrategy strategy;

    public Game(MovingStrategy strategy) {
        this.strategy = strategy;
    }

    public void racingCars() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Cars cars = inputView.initCars();
        CarsService carsService = new CarsService(this.strategy);
        for (int i = 0; i < inputView.getRounds(); i++) {
            cars = carsService.moveAll(cars);
            resultView.printAllCarsMovement(cars);
        }
        resultView.printWinners(cars.getWinners());
    }
}
