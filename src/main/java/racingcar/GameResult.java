package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    public List<Car> getWinner(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(car -> car.getPosition())
                .max()
                .orElse(cars.get(0).getPosition());

        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());

        return winners;
    }
}
