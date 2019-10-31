package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    private static final String RACER_NAME_SEPARATOR = ",";
    private static final RacingInput racingInput = new RacingInput(new Scanner(System.in));
    private static final RacingOutput racingOutput = new RacingOutput();

    public void start() {
        String racerNames = racingInput.inputRacerNames();
        int tryCount = racingInput.inputTryCount();
        Racers racers = signUp(racerNames);

        racingOutput.printResultMessage();
        race(racers, tryCount);
        racingOutput.printWinner(racers.winner());
    }

    private Racers signUp(String racerNames) {
        String[] racers = racerNames.split(RACER_NAME_SEPARATOR);
        List<Car> cars = new ArrayList<>();

        for (String racer : racers) {
            cars.add(new Car(racer));
        }

        return new Racers(cars);
    }

    private void race(Racers racers, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racers.moveAll();
            racingOutput.printCurrentStatus(racers);
        }
    }
}
