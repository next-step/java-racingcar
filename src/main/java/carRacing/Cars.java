package carRacing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public Map<String, Integer> getState() {
        Map<String, Integer> list = new HashMap<>();
        for (Car car : cars) {
            list.put(car.getCarName(), car.getDistance());
        }
        return list;
    }

    public List<String> callWinners() {
        List<String> result = new ArrayList<>();
        int maxDistance = maxDistance();

        for (Car car : cars) {
            findWinnerName(result, maxDistance, car);
        }

        return result;
    }

    private static void findWinnerName(List<String> result, int maxDistance, Car car) {
        if (isMaxDistance(maxDistance, car)) {
            result.add(car.getCarName());
        }
    }

    private static boolean isMaxDistance(int maxDistance, Car car) {
        return maxDistance == car.getDistance();
    }

    private int maxDistance() {
        int maxNumber = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxNumber = Math.max(car.getDistance(), maxNumber);
        }
        return maxNumber;
    }


}
