package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    /**
     * 우승자를 찾습니다.
     * @param cars
     * @return
     */
    public static List<Car> findWinners(List<Car> cars) {

        int maxScore = 0;
        for (Car car : cars) {
            maxScore = car.maxComparedTo(maxScore);
        }

        int finalMaxScore = maxScore;

        return cars.stream()
            .filter(car -> car.isSame(finalMaxScore))
            .collect(Collectors.toList());
    }
}
