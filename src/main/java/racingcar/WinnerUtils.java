package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerUtils {
    private static int highScore;

    public static List<Car> topRankSearch(List<Car> cars) {
        getHighScore(cars);
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isHighScore(highScore)) {
                winners.add(car);
            }
        }
        return winners;
    }

    private static void getHighScore(List<Car> cars) {
        for (Car car : cars) {
            replaceHighScore(car);
        }

    }

    private static void replaceHighScore(Car car) {
        if (car.getMovingDistance() > highScore) {
            highScore = car.getMovingDistance();
        }
    }

}
