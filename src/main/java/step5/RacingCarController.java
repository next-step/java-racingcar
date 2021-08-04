package step5;

import static step5.InputView.inputCarNames;
import static step5.InputView.inputTries;

public class RacingCarController {

    public static void run() {
        String[] carNames = inputCarNames();
        int tries = inputTries();
        newLine();
        runRacingCars(carNames, tries);
    }

    private static void runRacingCars(String[] carNames, int tries) {
        RacingCars racingCars = RacingCars.create(carNames);
        OutputView.printActionResult();
        for (int i = 0; i < tries; i++) {
            boolean isFirstTry = isFirstTry(i);

            if (!isFirstTry) {
                racingCars.run();
            }

            racingCars.getAll()
                    .stream()
                    .map(RacingCar::getStatus)
                    .forEach(OutputView::printResult);

            OutputView.println();

        }
        OutputView.printWinner(racingCars.getWinners());
    }

    private static boolean isFirstTry(int i) {
        return i == 0;
    }

    private static void newLine() {
        System.out.println();
    }

}
