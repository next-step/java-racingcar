package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerUtils {

    public static List<Car> topRankSearch(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int highScore = getHighScore(cars);
        for (Car car : cars) {
            if (car.isHighScore(highScore)) {
                winners.add(car);
            }
        }
        return winners;
    }

    private static int getHighScore(List<Car> cars) {
        int highScore = 0;
        for (Car car : cars) {
            if (car.compareToHighScore(highScore)) {
                highScore = car.getMovingDistance();
            }
        }
        return highScore;
    }
}
