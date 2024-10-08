package racing.controller;

import racing.domain.car.CarFactory;
import racing.domain.car.Cars;
import racing.domain.result.ResultRacings;
import racing.domain.game.RacingGame;
import racing.domain.game.RacingRandomCalculator;
import racing.domain.game.Winners;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingController {

    public void racingStart() {
        InputView input = new InputView(); //입력
        String carName = input.carInput();
        int cycle = input.cntInput();

        Cars cars = new Cars(CarFactory.generateCars(carName));

        RacingRandomCalculator racingRandomCalculator = new RacingRandomCalculator();
        RacingGame racingGame = new RacingGame(racingRandomCalculator);

        ResultRacings resultRacings = racingGame.racingCycle(cars, cycle); //레이싱

        resultPrint(resultRacings, cycle, cars); //뷰
    }

    private void resultPrint(ResultRacings resultRacings, int cycle, Cars cars) {
        Winners winners = new Winners();
        ResultView resultView = new ResultView();
        resultView.racingPrint(resultRacings, cycle);
        resultView.winnerPrint(winners.getWinners(cars));
    }
}
