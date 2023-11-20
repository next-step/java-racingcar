package racingCar.view.formatter;

import java.util.List;
import java.util.stream.Collectors;
import racingCar.domain.Car;

public class OutputFomatter {

    public String toCarName(Car car) {
        return car.getName();
    }

    public String toMovement(Car car) {
        return "-".repeat(car.getDistance());
    }

    public String toWinners(List<Car> winners) {
        List<String> winnerGroup = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        return String.join(",", winnerGroup);
    }
}
