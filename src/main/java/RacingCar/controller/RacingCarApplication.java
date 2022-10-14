package RacingCar.controller;

import RacingCar.domain.*;
import RacingCar.view.InputView;
import RacingCar.view.ResultView;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String carNames = inputView.carNames();
        int round = inputView.round();

        ResultView resultView = new ResultView();
        MovingStrategy movingStrategy = new RandomMovingStrategy();

        resultView.resultView();
        Cars cars = new Cars(carNames);
        for (int i = 0; i < round; i++) {
            cars.move(movingStrategy);
            resultView.roundView(cars.getCars());
        }

        Winner winner = new Winner(cars.getCars());
        List<Car> winners = winner.findWinners();
        resultView.winnerView(winners);
    }
}
