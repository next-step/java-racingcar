package race.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public static RacingCars createCars(int numOfCar, MovePolicy movePolicy) {
        List<Car> cars = IntStream.range(0, numOfCar)
                .mapToObj(i -> new Car(movePolicy))
                .collect(Collectors.toList());
        return new RacingCars(cars);
    }

    public static RacingCars createCars(CarNames carNames, MovePolicy movePolicy) {
        List<Car> cars = IntStream.range(0, carNames.size())
                .mapToObj(index -> new Car(carNames.get(index), movePolicy))
                .collect(Collectors.toList());
        return new RacingCars(cars);
    }

    public static RacingCars createRandomMoveCars(CarNames carNames) {
        return createCars(carNames, new RandomMovePolicy());
    }

    public void step() {
        cars.forEach(Car::move);
    }

    public List<Integer> getDistanceOfCars() {
        return cars.stream()
                .map(Car::getMovedDistance)
                .collect(Collectors.toList());
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }
}
