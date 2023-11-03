package study.racing.controller;

import study.racing.domain.CarsNumber;
import study.racing.domain.TryCounts;
import study.racing.view.InputView;
import study.racing.view.OutputView;

public class RacingController {

    private final OutputView outputView;
    private final InputView inputView;

    public RacingController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void startGame() {

        outputView.printCarsNumberMessage();
        CarsNumber carsNumber = inputView.inputCarsNumber();

        outputView.printRacingCountMessage();
        TryCounts tryCounts = inputView.inputTryCounts();

    }
}
