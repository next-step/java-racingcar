package racing.controller;

import racing.domain.Car;
import racing.domain.Cars;
import racing.strategy.RandomMovingStrategy;
import racing.view.ResultView;

import java.util.List;

public class Racing {

    private final List<Car> carList;
    private final int cntOfTry;

    public Racing(List<Car> carList, int cntOfTry) {
        this.carList = carList;
        this.cntOfTry = cntOfTry;
    }

    public String raceResultStr() {
        Cars cars = race();
        return cars.findWinnersName();
    }

    public List<Car> raceResultList() {
        Cars cars = race();
        return cars.findWinners();
    }

    private Cars race() {
        Cars cars = new Cars(carList);
        ResultView resultView = new ResultView();
        for (int i = 0; i < cntOfTry; i++) {
            cars.moveCars(new RandomMovingStrategy());
            resultView.printRacingResult(cars);
        }
        return cars;
    }
}
