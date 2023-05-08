package racingcar.service;

import racingcar.dto.Car;
import racingcar.dto.Cars;

import java.util.ArrayList;
import java.util.List;

public class RacingWinner {
    private static final String DELIMITER = ", ";

    private RacingWinner() {
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

    private static int getWinnerScore(Cars racingCars) {
        int winnerScore = 0;
        for (Car car : racingCars.getCars()) {
            winnerScore = checkWinnerScore(winnerScore, car);
        }
        return winnerScore;
    }

    private static int checkWinnerScore(int winnerScore, Car car) {
        int lastState = car.getState().get(getLastIndex(car));
        if (winnerScore < lastState) {
            winnerScore = lastState;
        }
        return winnerScore;
    }

    private static int getLastIndex(Car car) {
        return car.getState().size() - 1;
    }

    private static boolean hasWinnerScore(int winnerScore, Car car) {
        return winnerScore == car.getState().get(car.getState().size() - 1);
    }

    private static void addWinnerNames(int winnerScore, List<String> winnerNames, Car car) {
        String winnerName = getWinnerName(winnerScore, car);
        if(winnerName != null){
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
