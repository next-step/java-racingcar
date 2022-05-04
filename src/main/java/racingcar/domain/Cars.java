package racingcar.domain;

import racingcar.pattern.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String names) {
        this(createCars(names));
    }

    private static List<Car> createCars(String names) {
        String[] carNames = names.split(",");
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void play(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.play(numberGenerator.generate());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public Winners getWinners() {
        return new Winners(getCars().stream().filter(car -> car.isSamePosition(getMaxPosition())).collect(Collectors.toList()));
    }

    public Position getMaxPosition() {
        Position maxPosition = new Position(0);
        for (Car car : this.cars) {
            maxPosition = car.maxPosition(maxPosition);
        }
        return maxPosition;
    }

    public Map<String, Integer> getPositions() {
        return cars.stream()
                .collect(Collectors.toMap(
                        Car::getName,
                        Car::getDistance
                ));
    }
}
