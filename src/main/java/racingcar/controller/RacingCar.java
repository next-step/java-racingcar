package racingcar.controller;

import racingcar.RandomNumGenerator;
import racingcar.model.Cars;
import racingcar.model.Result;
import racingcar.model.Results;
import racingcar.model.Winners;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private Cars cars;
    private int tryCount;
    private Results Results;
    private Winners winners;

    public RacingCar(InputView inputView) {
        this.cars = inputView.getCars();
        this.tryCount = inputView.getTryCount();
    }

    public void startGame(RandomNumGenerator randomNumGenerator) {
        start(randomNumGenerator);
    }

    private void start(RandomNumGenerator randomNumGenerator) {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            Result result = cars.moveOnce(randomNumGenerator);
            results.add(result);
        }
        this.Results = new Results(results);

        findWinners();
    }

    private void findWinners() {
        this.winners = new Winners(cars.findWinner());
    }

    public Cars getCars() {
        return cars;
    }

    public racingcar.model.Results getResults() {
        return Results;
    }

    public Winners getWinners() {
        return winners;
    }
}