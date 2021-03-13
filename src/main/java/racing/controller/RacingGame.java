package racing.controller;

import racing.views.InputView;
import racing.views.ResultView;
import racing.domain.CarFactory;
import racing.domain.Cars;
import racing.domain.ConditionStrategy;
import racing.domain.InputDto;

public class RacingGame {
    private final InputView inputView;
    private final ConditionStrategy conditionStrategy;

    public RacingGame() {
        inputView = new InputView();
        conditionStrategy = new ConditionStrategy();
    }

    public void Race(Cars cars, int numberOfAttempts){
        ResultView.showResult();
        for (int i = 0; i < numberOfAttempts; i++) {
            cars.advanceCars(conditionStrategy);
            ResultView.showRaceRound(cars.getCars());
        }
    }

    public void start() {
        InputDto inputDto = inputView.generateInputDto();
        Cars cars = CarFactory.generateCars(inputDto.getNames());
        Race(cars, inputDto.getNumberOfAttempts());
        ResultView.showWinners(cars.getWinnerNames());
    }
}
