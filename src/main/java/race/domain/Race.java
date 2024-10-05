package race.domain;

import race.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Race {
    public static final int RANDOM_UPPER_LIMIT = 10;

    public static List<String> start(RaceInput raceInput) {
        List<RacingCar> cars = initiateCars(raceInput.carNames());

        for (int gameCount = 0; gameCount < raceInput.gameCount(); gameCount++) {
            runStopOrGoRound(cars);
        }

        return findWinners(cars);
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

    private static List<String> findWinners(List<RacingCar> cars) {
        int maxState = findMaxState(cars);

        return cars.stream()
                .filter(car -> car.isStateEqualWith(maxState))
                .map(RacingCar::name)
                .collect(Collectors.toList());
    }

    private static int findMaxState(List<RacingCar> cars) {
        int maxState = 0;

        for (RacingCar car : cars) {
            maxState = car.max(maxState);
        }

        return maxState;
    }

    private static int generateIntBetween0and9() {
        return new Random().nextInt(RANDOM_UPPER_LIMIT);
    }
}
