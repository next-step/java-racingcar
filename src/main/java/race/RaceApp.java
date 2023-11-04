package race;

import race.ui.InputView;

public class RaceApp {
    public static void main(String[] args) {
        final int carsCount = InputView.inputCarsCount();
        final int raceAttemptCount = InputView.inputRaceAttemptCount();

        final CarRacing carRacing = new CarRacing(carsCount);
        carRacing.start(raceAttemptCount);

    }
}
