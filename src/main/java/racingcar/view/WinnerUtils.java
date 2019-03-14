package racingcar.view;

import racingcar.domain.Car;
import racingcar.view.RacingResult;

import java.util.ArrayList;
import java.util.List;

public class WinnerUtils {

    public static List<Car> topRankSearch(RacingResult racingResult) {
        List<Car> winners = new ArrayList<>();
        int highScore = getHighScore(racingResult.getCars());
        for (Car car : racingResult.getCars()) {
            addWinners(winners, highScore, car);
        }
        return winners;
    }

    private static void addWinners(List<Car> winners, int highScore, Car car) {
        if (car.isHighScore(highScore)) {
            winners.add(car);
        }
    }

    public static int getHighScore(List<Car> cars) {
        int highScore = 0;
        for (Car car : cars) {
            highScore = car.compareToHighScore(highScore);
        }
        return highScore;
    }
}
