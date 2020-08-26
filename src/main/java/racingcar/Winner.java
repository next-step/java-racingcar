package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private int findMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }

    public String findWinner(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);

        List<String> winnerList = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(car -> car.getName())
                .collect(Collectors.toList());

        String winner = winnerList.stream()
                .collect(Collectors.joining(", "));

        return winner;
    }

}
