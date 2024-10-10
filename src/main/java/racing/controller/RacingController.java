package racing.controller;

import racing.domain.car.CarFactory;
import racing.domain.car.Cars;
import racing.domain.dto.ResultRacingsDTO;
import racing.domain.game.RacingGame;
import racing.domain.game.RacingRandomCalculator;
import racing.domain.game.Winners;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingController {

    private final InputView inputView;
    private final ResultView resultView;

    public RacingController(InputView inputView, ResultView resultView){
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void racingStart() {
        String carName = inputView.carInput();
        int cycle = inputView.cntInput();

        Cars cars = new Cars(CarFactory.generateCars(carName));

        RacingRandomCalculator racingRandomCalculator = new RacingRandomCalculator();
        RacingGame racingGame = new RacingGame(racingRandomCalculator);

        ResultRacingsDTO resultRacingsDTO = racingGame.racingCycle(cars, cycle); //레이싱

        resultPrint(resultRacingsDTO, cycle, cars); //뷰
    }

    private void resultPrint(ResultRacingsDTO resultRacingsDTO, int cycle, Cars cars) {
        Winners winners = new Winners();
        resultView.racingPrint(resultRacingsDTO, cycle);
        resultView.winnerPrint(winners.getWinners(cars));
    }
}
