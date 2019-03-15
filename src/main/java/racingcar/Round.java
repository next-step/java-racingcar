package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Round {
    List<Car> cars;

    public Round(List<Car> cars) {
        this.cars = new ArrayList<>();
        cars.forEach(car -> this.cars.add(car.copy()));
    }

    public String getWinnerId() {
        int winnerPosition = getWinnerPosition();
        List<Car> winnerCars = getWinnerCars(winnerPosition);
        return getCarsId(winnerCars);
    }

    public String displayTraces() {
        return this.cars.stream()
                .map(it -> it.displayTrace())
                .collect(Collectors.joining("\n"));
    }

    private int getWinnerPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo).orElseThrow(RuntimeException::new);
    }

    private List<Car> getWinnerCars(int winnerPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .collect(Collectors.toList());
    }

    private String getCarsId(List<Car> winnerCars) {
        return winnerCars.stream()
                .map(Car::getId)
                .collect(Collectors.joining(", "));
    }
}
