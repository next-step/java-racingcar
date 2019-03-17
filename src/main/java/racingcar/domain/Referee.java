package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    private int getMaxPosition(List<Car> cars) {
        Car maxCar = cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(() -> new RuntimeException("경주에서 우승한 차가 없습니다."));
        return maxCar.getPosition();
    }

    public List<String> pickNamesOfWinners(List<Car> cars) {
        int MaxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == MaxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}