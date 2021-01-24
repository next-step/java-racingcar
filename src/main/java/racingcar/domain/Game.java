package racingcar.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Game {

    private final int RANDOM_MAX_RANGE = 10;

    public String getWinners(List<Car> cars) {
        int maxPosition = getMax(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

    private int getMax(List<Car> cars) {
        int max = -1;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }

    private int generateToken() {
        Random random = new Random();
        return random.nextInt(RANDOM_MAX_RANGE);
    }

    public void proceedRound(List<Car> cars) {
        for (Car car : cars) {
            car.move(generateToken());
        }
    }
}
