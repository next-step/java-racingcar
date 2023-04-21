package study.racingcar.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class GameCars implements Iterable<Car> {
    private final List<Car> cars;

    public GameCars(List<String> carNames) {
        this.cars = new ArrayList<>();
        generateCars(carNames);
    }

    private void generateCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }

    public Winners calculateWinner() {
        int maxPosition = calculateMaxPosition();
        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toUnmodifiableList());
        return new Winners(winners);
    }

    private int calculateMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
    }
}
