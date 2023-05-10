package racingcar.service;

import racingcar.dto.Car;
import racingcar.dto.Cars;

import java.util.ArrayList;
import java.util.List;

import static racingcar.service.RacingScores.getWinnerScore;

public class RacingWinners {
    private static final String DELIMITER = ", ";

    private RacingWinners() {
        throw new AssertionError();
    }

    public static String getWinnerNames(Cars racingCars) {
        int winnerScore = getWinnerScore(racingCars);

        List<String> winnerNames = new ArrayList<>();
        for (Car car : racingCars.getCars()) {
            addWinnerNames(winnerScore, winnerNames, car);
        }

        return String.join(DELIMITER, winnerNames);
    }

    private static boolean hasWinnerScore(int winnerScore, Car car) {
        return winnerScore == car.getState().get(car.getState().size() - 1);
    }

    private static void addWinnerNames(int winnerScore, List<String> winnerNames, Car car) {
        String winnerName = getWinnerName(winnerScore, car);
        if (winnerName != null) {
            winnerNames.add(winnerName);
        }
    }

    private static String getWinnerName(int winnerScore, Car car) {
        if (!hasWinnerScore(winnerScore, car)) {
            return null;
        }

        return car.getName();
    }
}
