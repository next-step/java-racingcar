package step3;

import static step3.InputView.inputCars;
import static step3.InputView.inputTries;

public class RacingCarController {

    public static void run() {

        int cars = inputCars();
        int tries = inputTries();
        newLine();

        RacingCars racingCars = RacingCars.create(cars);
        OutputView.printResult(racingCars, tries);

    }

    private static void newLine() {
        System.out.println();
    }

}
