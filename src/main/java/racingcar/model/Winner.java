package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private String winner;

    public Winner(List<Car> cars) {
        int max = cars.stream().mapToInt(Car::getPosition).max().getAsInt();
         winner = cars.stream().filter(car -> car.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    public String getWinner() {
        return winner;
    }
}
