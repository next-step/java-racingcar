package RacingCar.controller;

import RacingCar.domain.*;
import RacingCar.view.InputView;
import RacingCar.view.ResultView;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String carListString = inputView.carNames();
        int round = inputView.round();

        Racing racing = new Racing(round);
        Cars cars = new Cars();
        List<Car> racingCars = cars.makeCars(carListString);
        Winner winner = new Winner();
        ResultView resultView = new ResultView();
        RandomNumber randomNumber = new RandomNumber();

        resultView.resultView();

        for (int i = 0; i < racing.getRound(); i++) {
            racing.round(randomNumber, racingCars);
            resultView.roundView(racingCars);
        }

        List<Car> winners = winner.findWinners(racingCars);

        resultView.winnerView(winners);
    }
}
