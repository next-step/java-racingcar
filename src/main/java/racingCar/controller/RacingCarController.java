package racingCar.controller;

import racingCar.model.RacingCar;
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

        inputView.scan();

        racingCars = RacingCar.createMulti(inputView.carCnt());
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

        resultView.printCarsDistance(racingCars);
    }

    public void race() {

        resultView.printResultTitle();

        for (int raceIndex = 0; raceIndex < inputView.moveCnt(); raceIndex++) {
            raceOnce();
        }
    }
}
