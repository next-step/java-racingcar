package racinggame.controller;

import racinggame.domain.car.Cars;
import racinggame.domain.history.RoundHistories;
import racinggame.domain.random.RandomGoRule;
import racinggame.view.InputView;

public class RacingGameController {

    public RacingGameController(){

    }

    public RoundHistories race(InputView inputView, Cars cars) {
        final RandomGoRule randomGenerator = new RandomGoRule();
        final int playGameNumber = inputView.inputTryNumber();
        final RoundHistories roundHistories = new RoundHistories();
        for (int i=0; i<playGameNumber; i++) {
            cars.move(randomGenerator);
            roundHistories.captureRoundHistory(cars);
        }
        return roundHistories;
    }

    public Cars initCars(InputView inputView) {
        final String[] carNames = inputView.inputPlayerName();
        final Cars cars = new Cars(carNames);
        return cars;
    }

}
