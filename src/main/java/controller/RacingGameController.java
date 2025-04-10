package controller;

import model.Car;
import model.Cars;
import model.MoveStrategy;
import view.ResultView;

import java.util.List;

public class RacingGameController {
    private final int numberOfRounds;
    private final Cars cars;
    private static final ResultView resultView = new ResultView();


    public RacingGameController(int numberOfRounds, String[] carNames, MoveStrategy moveStrategy) {
        this.numberOfRounds = numberOfRounds;
        this.cars = new Cars(carNames, moveStrategy);
    }

    public void startRace() {
        for (int i = 0; i < numberOfRounds; i++) {
            List<Car> roundResult = cars.moveAllCars();
            resultView.printRoundResult(roundResult);
        }
    }

    public List<Car> getResult() {
        return cars.findWinningCar();
    }
}
