package racingcarRefactor.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Game {

    public String getWinners(List<Car> cars) {
        int maxPosition = getMax(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(car1 -> car1.getName())
                .collect(Collectors.joining(","));
    }

    private int getMax(List<Car> cars) {
        int max = -1;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }

    public void round(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }
}
