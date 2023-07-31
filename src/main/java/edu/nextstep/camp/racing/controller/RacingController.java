package edu.nextstep.camp.racing.controller;

import edu.nextstep.camp.racing.domain.Cars;
import edu.nextstep.camp.racing.domain.RacingGame;
import edu.nextstep.camp.racing.domain.RacingResult;
import edu.nextstep.camp.racing.view.RacingInputView;
import edu.nextstep.camp.racing.view.RacingOutputView;

import java.util.List;

public class RacingController {

    private final RacingInputView inputView;
    private final RacingOutputView outputView;

    public RacingController(RacingInputView inputView, RacingOutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public Cars inputCars() {
        return inputView.carsInput();
    }

    public void start(Cars cars) {
        int movingCount = inputView.movingCountInput();

        List<RacingResult> racingResults = new RacingGame().startGame(cars, movingCount);

        outputView.racingResultView(racingResults, cars.winners());
    }
}
