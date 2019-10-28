package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final String RACER_NAME_SEPARATOR = ",";

    public void start() {
        String racerNames = RacingInput.inputString(RacingInputType.CAR);
        int tryCount = RacingInput.inputInt(RacingInputType.TRY);
        Racers racers = signUp(racerNames);

        RacingOutput.printResultMessage();
        race(racers, tryCount);
        RacingOutput.printWinner(racers.winner());
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
            RacingOutput.printCurrentStatus(racers);
        }
    }
}
