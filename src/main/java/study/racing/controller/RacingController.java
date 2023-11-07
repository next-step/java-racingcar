package study.racing.controller;

import study.racing.domain.Cars;
import study.racing.domain.CarsNumber;
import study.racing.domain.Names;
import study.racing.domain.NumberGenerator;
import study.racing.view.InputView;
import study.racing.view.OutputView;

public class RacingController {

    private final OutputView outputView;
    private final InputView inputView;
    private final NumberGenerator randomGenerator;

    public RacingController(OutputView outputView, InputView inputView, NumberGenerator randomGenerator) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.randomGenerator = randomGenerator;
    }

    public void startGame() {

        outputView.printCarsNumberMessage();
        Names names = inputView.inputCarsNumber();
        Cars cars = new Cars(names);

        outputView.printRacingCountMessage();
        String results = cars.move(randomGenerator, inputView.inputTryCounts());

        outputView.printRacingResultMessage(results);
    }
}
