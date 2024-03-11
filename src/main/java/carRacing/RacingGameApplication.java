package carRacing;

import carRacing.car.Cars;
import carRacing.common.InputHandler;
import carRacing.common.RandomGenerator;
import carRacing.common.RandomGeneratorImpl;
import carRacing.race.RacingGame;
import carRacing.race.RacingGameUI;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingGameApplication {
    public static void main(String[] args) throws Exception {

        RandomGenerator randomGenerator = RandomGeneratorImpl.of();
        Cars cars = Cars.of(new ArrayList<>());
        RacingGameUI ui = new RacingGameUI();
        RacingGame racingGame = RacingGame.of(randomGenerator,cars,ui);

        InputHandler inputHandler = InputHandler.of();

        try{
            String carNames = inputHandler.askCarsNames();
            int trialCount = inputHandler.askTrialCount();
            racingGame.startRacing(carNames, trialCount);
        }finally {
            inputHandler.closeScanner();
        }

    }
}
