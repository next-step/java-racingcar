package racingcar.controller;

import racingcar.RandomNumGenerator;
import racingcar.model.*;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {
    private int tryCount;
    private Cars cars;
    private Results Results;
    private Winners winners;
    private List<String> carNames;
    private RandomNumGenerator randomNumGenerator;

    public RacingCar(InputView inputView) {
        this.carNames = inputView.getCarNames();
        this.tryCount = inputView.getTryCount();
    }

    public void startGame(RandomNumGenerator randomNumGenerator) {
        this.randomNumGenerator = randomNumGenerator;
        ready();
    }

    private void ready(){
        List<Car> allCars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        cars = new Cars(allCars);
        start();
    }

    private void start() {
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