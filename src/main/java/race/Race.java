package race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    public static final int RANDOM_UPPER_LIMIT = 10;

    public static void start() {
        RaceInput raceInput = InputView.getRaceInput();
        List<RacingCar> cars = initiateCars(raceInput.carNames());

        ResultView.printResultTitle();
        for (int gameCount = 0; gameCount < raceInput.gameCount(); gameCount++) {
            runStopOrGoRound(cars);
        }
    }

    public static List<RacingCar> initiateCars(List<String> carNames) {
        List<RacingCar> cars = new ArrayList<>();

        for (String carName : carNames) {
            RacingCar car = new RacingCar(carName);
            cars.add(car);
        }

        return cars;
    }

    private static void runStopOrGoRound(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            int generatedRandom = generateIntBetween0and9();
            car.moveCarForwardIfCanGo(generatedRandom);
        }
        ResultView.printCarStates(cars);
    }

    private static int generateIntBetween0and9() {
        return new Random().nextInt(RANDOM_UPPER_LIMIT);
    }
}
