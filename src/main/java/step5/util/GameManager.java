package step5.util;

import step5.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    public static List<RacingCar> makeCars(final String[] carNames) {
        List<RacingCar> cars = new ArrayList<>();

        for (final String carName : carNames) {
            cars.add(new RacingCar(carName));
        }

        return cars;
    }

    public static List<RacingCar> extractWinners(final List<RacingCar> cars) {
        cars.sort(null);

        final RacingCar winnerCar = cars.get(0);

        List<RacingCar> winnerCars = new ArrayList<>();

        for (final RacingCar car : cars) {
            addCarIfWinnerDistanceEqualWithCarDistance(winnerCar, car, winnerCars);
        }

        return winnerCars;
    }

    private static void addCarIfWinnerDistanceEqualWithCarDistance(final RacingCar winnerCar, final RacingCar car, final List<RacingCar> winnerCars) {
        if (winnerCar.currentDistance() != car.currentDistance()) {
            return;
        }

        winnerCars.add(car);
    }

    public static String[] toNames(final List<RacingCar> winners) {
        String[] winnerNames = new String[winners.size()];

        for (int i = 0; i < winners.size(); i++) {
            final RacingCar winner = winners.get(i);

            winnerNames[i] = winner.carName();
        }

        return winnerNames;
    }
}
