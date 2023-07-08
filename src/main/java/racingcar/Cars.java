package racingcar;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(toList()));
    }

    public void takeTurn() {
        for (Car car : cars) {
            car.progress();
        }
    }

    public List<String> getMaxDistanceCarNames() {
        return getMaxDistanceCars().stream().map(Car::getName).collect(toList());
    }

    public RacingRoundRecord getRecord() {
        return RacingRoundRecord.from(cars);
    }

    public List<Car> getMaxDistanceCars() {
        Car maxDistanceCar = getMaxDistanceCar();
        return cars.stream().filter(car -> car.isSameDistance(maxDistanceCar)).collect(toList());
    }

    private Car getMaxDistanceCar() {
        Car maxDistanceCar = cars.get(0);
        for (Car car : cars) {
            maxDistanceCar = maxDistanceCar.returnFurtherMovedCar(car);
        }
        return maxDistanceCar;
    }
}
