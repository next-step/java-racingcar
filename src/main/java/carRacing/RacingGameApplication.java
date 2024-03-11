package carRacing;

import carRacing.car.Cars;
import carRacing.common.RandomGenerator;
import carRacing.common.RandomGeneratorImpl;
import carRacing.race.RacingGame;
import carRacing.race.RacingGameUI;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingGameApplication {
    public static void main(String[] args) throws Exception {

        RandomGenerator randomGenerator = new RandomGeneratorImpl();
        Cars cars = Cars.of(new ArrayList<>());
        RacingGameUI ui = new RacingGameUI();
        RacingGame racingGame = RacingGame.of(randomGenerator,cars,ui);

        String carNames = ui.askCarsNames();
        int trialCount = ui.askTrialCount();
        racingGame.startRacing(carNames, trialCount);

    }
}
