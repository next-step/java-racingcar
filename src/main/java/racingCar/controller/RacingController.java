package racingCar.controller;

import racingCar.domain.Car;
import racingCar.domain.Race;
import racingCar.view.InputView;
import racingCar.view.ResultView;

import java.util.List;

public class RacingController {

    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void Race() {
        int carCount = this.inputView.EnterCarNumber();
        int moveCount = this.inputView.EnterMoveCount();

        Race race = new Race(carCount);

        start(race, moveCount, carCount);
    }

    private void start(Race race, int moveCount, int carCount) {
        this.resultView.printExecutionResultMessage();

        for(int i = 0; i < moveCount; i++) {
            race = race.moveCar();
            outputCarDistance(race.getCars(), carCount);
        }
    }

    private void outputCarDistance(List<Car> cars, int carCount) {
        for(int i = 0; i < carCount; i++) {
            this.resultView.printCarDistance(cars.get(i).getCarDistance());
        }
        this.resultView.printEnter();
    }

}
