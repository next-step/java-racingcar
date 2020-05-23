package study.racing.utils;

import study.racing.model.Car;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingUtils {
    private static final int MAX_RANDOM_NUM = 10;

    private static Random random = new Random();

    public static List<Car> getWinners(List<Car> cars) {
        Map<Integer, List<Car>> carsGroupedByPosition = groupingByCarPosition(cars);

        Integer winnerPosition = findWinnerPosition(carsGroupedByPosition);

        return carsGroupedByPosition.get(winnerPosition);
    }

    private static Map<Integer, List<Car>> groupingByCarPosition(List<Car> cars) {
        return cars.stream().collect(Collectors.groupingBy(Car::getPosition));
    }

    private static Integer findWinnerPosition(Map<Integer, List<Car>> carsGroupedByPosition) {
        return Collections.max(carsGroupedByPosition.keySet());
    }

    public static int getRandomNumber() {
        return random.nextInt(MAX_RANDOM_NUM);
    }
}
