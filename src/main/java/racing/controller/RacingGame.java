package racing.controller;

import racing.domain.CarFactory;
import racing.domain.Cars;
import racing.domain.ConditionStrategy;
import racing.views.InputView;
import racing.views.ResultView;

import java.util.List;

public class RacingGame {
    private final InputView inputView;
    private final ResultView resultView;
    private final ConditionStrategy conditionStrategy;

    public RacingGame() {
        inputView = new InputView();
        resultView = new ResultView();
        conditionStrategy = new ConditionStrategy();
    }

    public void Race(Cars cars, int numberOfAttempts){
        resultView.showStartRace(cars.getCars());
        for (int i = 0; i < numberOfAttempts; i++) {
            cars.advanceCars(conditionStrategy);
            resultView.showRaceRound(cars.getCars());
        }
    }

    public void start() {
        List<String> names = inputView.getNames();
        int numberOfAttempts = inputView.getNumberOfAttempts();
        Cars cars = CarFactory.generateCars(names);
        Race(cars, numberOfAttempts);
        resultView.showWinners(cars.getWinnerNames());
    }
}
