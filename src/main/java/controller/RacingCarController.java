package controller;

import java.util.ArrayList;
import java.util.List;

import model.RacingCar;
import model.RandomNumberGenerator;
import view.InputView;

public class RacingCarController {

    private final InputView inputView;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingCarController(final InputView inputView, final RandomNumberGenerator randomNumberGenerator) {
        this.inputView = inputView;
        this.randomNumberGenerator = randomNumberGenerator;
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
                System.out.println("randomNumber = " + randomNumber);
                racingCar.move(randomNumber);
            }

            for (final RacingCar racingCar : racingCars) {
                for (int j = 0; j < racingCar.getLocation(); j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }
}
