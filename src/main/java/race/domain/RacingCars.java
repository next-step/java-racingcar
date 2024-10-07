package race.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingCars {
    public static final int RANDOM_UPPER_LIMIT = 10;

    private final List<RacingCar> racingCars;

    public static RacingCars from(List<String> carNames) {
        return new RacingCars(carNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList())
        );
    }

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void startRound() {
        for (RacingCar car : racingCars) {
            int randomNumber = generateIntBetween0and9();
            car.moveCarForwardIfCanGo(randomNumber);
        }
    }

    @Override
    public String toString() {
        StringBuilder carStates = new StringBuilder();

        for (RacingCar car : racingCars) {
            carStates.append(String.format("%s%n", car));
        }

        return carStates.toString();
    }

    private static int generateIntBetween0and9() {
        return new Random().nextInt(RANDOM_UPPER_LIMIT);
    }

    public List<String> findWinners() {
        int maxState = maxState();

        return racingCars.stream()
                .filter(car -> car.isStateEqualWith(maxState))
                .map(RacingCar::name)
                .collect(Collectors.toList());
    }

    private int maxState() {
        int maxState = 0;

        for (RacingCar car : racingCars) {
            maxState = car.max(maxState);
        }

        return maxState;
    }
}
