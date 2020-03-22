package racingcar.controller;

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

    public RacingCar(InputView inputView) {
        this.carNames = inputView.getCarNames();
        this.tryCount = inputView.getTryCount();
    }

    public void start() {
        ready();
    }

    private void ready() {
        List<Car> allCars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        cars = new Cars(allCars);
        startGame();
    }

    private void startGame() {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            Result result = cars.moveOnce();
            results.add(result);
        }
        this.Results = new Results(results);
        findWinners();
    }

    private void findWinners() {
        this.winners = new Winners(cars.findWinner());
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