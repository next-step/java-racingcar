package racingCar.controller;

import racingCar.model.RacingCar;
import racingCar.util.RacingCarUtil;
import racingCar.view.InputView;
import racingCar.view.ResultView;

import java.util.List;

public class RacingCarController {

    private List<RacingCar> racingCars;

    private InputView inputView;
    private ResultView resultView;

    public RacingCarController() {
        inputView = new InputView();
        resultView = new ResultView();

        // inputView.scan();
        inputView.scanWithNames();

        // racingCars = RacingCar.createMulti(inputView.carCnt());
        String[] carNames = RacingCarUtil.inputNameToCarNames(inputView.carNames());
        inputView.severalCars(carNames.length);
        racingCars = RacingCar.createMultiWithNames(carNames);
    }

    public RacingCarController(List<RacingCar> racingCars, InputView inputView, ResultView resultView) {
        this.racingCars = racingCars;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    private void raceOnce() {

        for (int carIndex = 0; carIndex < inputView.carCnt(); carIndex++) {
            racingCars.get(carIndex).race();
        }

        // resultView.printCarsDistance(racingCars);
        resultView.printCarsNameAndDistance(racingCars);
    }

    public void race() {

        resultView.printResultTitle();

        for (int raceIndex = 0; raceIndex < inputView.moveCnt(); raceIndex++) {
            raceOnce();
        }

        resultView.printRaceWinner(racingCars);
    }
}
