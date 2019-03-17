package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Round {
    private List<CarDTO> cars;

    Round(List<Car> cars) {
        this.cars = cars.stream()
                .map(Car::toCarDTO)
                .collect(Collectors.toList());
    }

    List<CarDTO> getCars() {
        return cars;
    }

    Winners getWinners() {
        int winnerPosition = getWinnerPosition(this.cars);
        return getWinnerCars(winnerPosition);
    }

    private int getWinnerPosition(List<CarDTO> cars) {
        return cars.stream()
                .map(CarDTO::getPosition)
                .max(Integer::compareTo).orElseThrow(RuntimeException::new);
    }

    private Winners getWinnerCars(int winnerPosition) {
        List<CarDTO> winners = this.cars.stream()
                .filter(car -> car.isPositionOf(winnerPosition))
                .collect(Collectors.toList());
        return new Winners(winners);
    }
}
