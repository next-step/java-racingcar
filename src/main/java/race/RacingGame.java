package race;

import race.view.OutputView;

public class RacingGame {

    public void start(int numberOfCars, int count) {
        OutputView.printResultComment();
        for (int i = 0; i < count; i++) {
            race(numberOfCars, i);
            OutputView.printRacingRound();
        }
    }

    private void race(int numberOfCars, int i) {
        OutputView.printCarMileage(numberOfCars, i);
    }

}
