package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Round {
    List<Car> cars;

    public Round(List<Car> cars) {
        this.cars = new ArrayList<>();
        cars.forEach(car -> this.cars.add(new Car(car.getId(), car.getPosition())));
    }

    public String getWinnerId() {
        int winnerPosition = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo).orElseThrow(RuntimeException::new);

        List<Car> winnerCars = cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .collect(Collectors.toList());

        return winnerCars.stream()
                .map(Car::getId)
                .collect(Collectors.joining(", "));
    }
}
