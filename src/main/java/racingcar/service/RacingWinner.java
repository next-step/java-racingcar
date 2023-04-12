package racingcar.service;

import java.util.List;

public class RacingWinner {

    public static String getWinnerNames(List<Car> racingCars) {
        int winnerScore = getWinnerScore(racingCars);

        StringBuilder winnerNames = new StringBuilder();
        for (Car car : racingCars) {
            winnerNames = hasWinnerScore(winnerScore, car) ? appendWinnerName(winnerNames, car) : winnerNames;
        }

        return winnerNames.toString();
    }

    private static boolean hasWinnerScore(int winnerScore, Car car) {
        return winnerScore == car.getState().get(car.getState().size() - 1);
    }

    private static StringBuilder appendWinnerName(StringBuilder winnerNames, Car car) {
        if(winnerNames.length() != 0){
            winnerNames.append(", ");
        }
        winnerNames.append(car.getName());

        return winnerNames;
    }

    private static int getWinnerScore(List<Car> racingCars) {
        int winnerScore = 0;
        for (Car car : racingCars) {
            winnerScore = checkWinnerScore(winnerScore, car);
        }
        return winnerScore;
    }

    private static int checkWinnerScore(int winnerScore, Car car) {
        int lastState = car.getState().get(car.getState().size() - 1);
        if (winnerScore < lastState) {
            winnerScore = lastState;
        }
        return winnerScore;
    }
}
