package racing.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ranking {

    private static final Map<Integer, List<String>> ranking = new HashMap<>();

    public static List<String> findWinners(List<Car> cars) {

        ranking.clear();

        rankCars(cars);

        int maxPosition = Collections.max(ranking.keySet());

        return ranking.get(maxPosition);
    }

    private static void rankCars(List<Car> cars) {
        for (Car car : cars) {
            car.rank(ranking);
        }
    }
}
