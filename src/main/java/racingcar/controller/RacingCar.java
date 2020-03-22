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
    private InputView inputView;
    private Cars cars;

    public RacingCar(InputView inputView) {
        this.inputView = inputView;
    }

    public Cars ready() {
        this.cars = new Cars(inputView);
        return cars;
    }

    public Results start(RandomNumGenerator randomNumGenerator) {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < inputView.getTryCount(); i++) {
            Result result = cars.moveOnce(randomNumGenerator);
            results.add(result);
        }
        return new Results(results);
    }

    public Winners findWinners() {
        return new Winners(cars.findWinner());
    }
}