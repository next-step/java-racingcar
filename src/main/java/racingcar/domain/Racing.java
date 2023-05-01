package racingcar.domain;

import racingcar.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {
    public static final String CAR_NAMES_SEPARATOR = ",";

    private final List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public Racing(String carNames) {
        this.cars = initCars(carNames);
    }

    public Racing(List<Car> cars) {
        this.cars = cars;
    }

    private List<Car> initCars(String carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames.split(CAR_NAMES_SEPARATOR)) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public List<Car> race(NumberGenerator numberGenerator) {
        IntStream.range(0, cars.size())
                .forEach(j -> cars.get(j).move(numberGenerator));

        return cars;
    }

    public WinnerCars getWinnerCars() {
        int maxMovementCount = cars.stream()
                .map(Car::getMovementCount)
                .max(Integer::max).get();

        List<Car> winnerCars = cars.stream().filter(car -> car.isWinnerMovementCount(maxMovementCount))
                .collect(Collectors.toList());

        return new WinnerCars(winnerCars);
    }
}
