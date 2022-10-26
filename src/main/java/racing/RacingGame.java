package racing;

import racing.domain.Cars;

import static racing.view.RacingResultView.printResultMessage;

public class RacingGame {

    public static void race(int gameCount, Cars cars) {
        printResultMessage();
        for (int i = 0; i < gameCount; i++) {
            cars.moveCars();
        }
    }
}
