package racingcar.controller;

import racingcar.model.*;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class RacingCar {
    private int tryCount;
    private Cars cars;
    private Results Results;
    private Winners winners;

    public RacingCar(InputView inputView) {
        this.tryCount = inputView.getTryCount();
        ready(inputView.getCarNames());
    }

    private void ready(List<String> carNames) {
        cars = carNames.stream()
                .map(Car::new)
                .collect(collectingAndThen(toList(), Cars::new));
    }

    public void start() {
        startGame();
        findWinners(this.getResults());
    }

    private void startGame() {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            Result result = cars.moveOnce();
            results.add(result);
        }
        this.Results = new Results(results);
    }

    private void findWinners(List<Result> results) {
        if (results != null) {
            this.winners = new Winners(cars.findWinner());
        }
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<Result> getResults() {
        return Results.getResults();
    }

    public List<Car> getWinners() {
        return winners.getWinners();
    }
}