package study.racing.controller;

import study.racing.domain.Cars;
import study.racing.domain.CarsNumber;
import study.racing.domain.RandomGenerator;
import study.racing.domain.TryCounts;
import study.racing.view.InputView;
import study.racing.view.OutputView;

public class RacingController {

    private static final String NEXT_LINE = "\n";
    private final OutputView outputView;
    private final InputView inputView;
    private final RandomGenerator randomGenerator;

    public RacingController(OutputView outputView, InputView inputView, RandomGenerator randomGenerator) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.randomGenerator = randomGenerator;
    }

    public void startGame() {

        StringBuilder positionBuilder = new StringBuilder();
        outputView.printCarsNumberMessage();
        CarsNumber carsNumber = inputView.inputCarsNumber();

        Cars cars = new Cars(carsNumber);

        outputView.printRacingCountMessage();
        TryCounts tryCounts = inputView.inputTryCounts();

        for (int i = 0; i < tryCounts.getValue(); i++) {
            positionBuilder.append(cars.move(randomGenerator));
            positionBuilder.append(NEXT_LINE);
        }

        outputView.printRacingResultMessage(positionBuilder.toString());
    }
}
