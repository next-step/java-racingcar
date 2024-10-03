package race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    public static final int RANDOM_UPPER_LIMIT = 10;

    public static void start() {
        RaceInput raceInput = InputView.inputCarCountAndGameCount();
        List<RacingCar> cars = initiateCars(raceInput.carCount());

        ResultView.printResultTitle();
        for (int gameCount = 0; gameCount < raceInput.gameCount(); gameCount++) {
            runStopOrGoRound(cars);
        }
    }

    public static List<RacingCar> initiateCars(int carCount) {
        List<RacingCar> cars = new ArrayList<>();

        for (int carIndex = 0; carIndex < carCount; carIndex++) {
            RacingCar car = new RacingCar();
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
