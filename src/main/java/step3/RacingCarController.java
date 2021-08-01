package step3;

import static step3.InputView.inputCars;
import static step3.InputView.inputTries;

public class RacingCarController {

    public static void run() {
        int cars = inputCars();
        int tries = inputTries();
        newLine();
        runRacingCars(cars, tries);
    }

    private static void runRacingCars(int cars, int tries) {
        RacingCars racingCars = RacingCars.create(cars);
        for (int i = 0; i < tries; i++) {
            boolean isFirstTry = isFirstTry(i);
            if (!isFirstTry) {
                racingCars.run();
            }
            OutputView.printResult(racingCars, isFirstTry);
        }
    }

    private static boolean isFirstTry(int i) {
        return i == 0;
    }

    private static void newLine() {
        System.out.println();
    }

}
