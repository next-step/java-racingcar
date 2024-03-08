package controller;

import java.util.ArrayList;
import java.util.List;

import model.RacingCar;
import model.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final RandomNumberGenerator randomNumberGenerator;
    private final OutputView outputView;

    public RacingCarController(final InputView inputView, final RandomNumberGenerator randomNumberGenerator,
                               final OutputView outputView) {
        this.inputView = inputView;
        this.randomNumberGenerator = randomNumberGenerator;
        this.outputView = outputView;
    }

    public void start() {
        final int racingCarNumber = inputView.inputRacingCarNumber();
        final int tryNumber = inputView.inputTryNumber();

        final List<RacingCar> racingCars = new ArrayList<>();

        for (int i = 0; i < racingCarNumber; i++) {
            racingCars.add(new RacingCar());
        }

        for (int i = 0; i < tryNumber; i++) {
            for (final RacingCar racingCar : racingCars) {
                final int randomNumber = randomNumberGenerator.generate();
                racingCar.move(randomNumber);
            }
            outputView.printResult(racingCars);
        }
    }
}
