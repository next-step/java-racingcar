package racingcar.step4;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private static int MAX = Integer.MIN_VALUE;

    public static List<Car> startRaceGame(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = RandomUtil.generateRandomNumber();
            car.move(randomNumber);
        }

        return cars;
    }

    public static List<String> getWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == getMaxDistance(cars)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public static int getMaxDistance(List<Car> cars) {
        for (Car car : cars) {
            getMax(car.getDistance());
        }
        return MAX;
    }

    public static int getMax(int distance) {
        if (distance > MAX) {
            MAX = distance;
        }
        return MAX;
    }
}
