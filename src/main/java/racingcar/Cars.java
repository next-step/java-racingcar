package racingcar;

import racingcar.movable.Movable;
import racingcar.movable.RandomMovable;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Cars {

    private final List<Car> cars;
    private final Movable movable;

    public Cars(List<Car> cars) {
        this.movable = new RandomMovable();
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(toList()));
    }

    public void takeTurn() {
        for (Car car : cars) {
            car.progress(movable);
        }
    }

    public List<String> getMaxDistanceCarNames() {
        return getMaxDistanceCars().stream()
                .map(Car::getName)
                .collect(toList());
    }

    public RacingRoundRecord getRecord() {
        return RacingRoundRecord.from(cars);
    }

    private List<Car> getMaxDistanceCars() {
        return cars.stream()
                .filter(car -> car.isSameDistance(getMaxDistanceCar()))
                .collect(toList());
    }

    private Car getMaxDistanceCar() {
        Car maxDistanceCar = cars.get(0);
        for (Car car : cars) {
            maxDistanceCar = maxDistanceCar.returnFurtherMovedCar(car);
        }
        return maxDistanceCar;
    }
}
