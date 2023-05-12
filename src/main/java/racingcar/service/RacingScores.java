package racingcar.service;

import racingcar.dto.Car;
import racingcar.dto.Cars;

public class RacingScores {

    private RacingScores() {
        throw new AssertionError();
    }

    public static int getWinnerScore(Cars racingCars) {
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
}
