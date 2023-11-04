package study.racing.controller;

import study.racing.domain.Cars;
import study.racing.domain.CarsNumber;
import study.racing.domain.RandomGenerator;
import study.racing.view.InputView;
import study.racing.view.OutputView;

public class RacingController {

    private final OutputView outputView;
    private final InputView inputView;
    private final RandomGenerator randomGenerator;

    public RacingController(OutputView outputView, InputView inputView, RandomGenerator randomGenerator) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.randomGenerator = randomGenerator;
    }

    public void startGame() {

        outputView.printCarsNumberMessage();
        CarsNumber carsNumber = inputView.inputCarsNumber();
        Cars cars = new Cars(carsNumber);

        outputView.printRacingCountMessage();
        String results = cars.move(randomGenerator, inputView.inputTryCounts());

        outputView.printRacingResultMessage(results);
    }
}
