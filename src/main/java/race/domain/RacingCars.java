package race.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCars {
    private static final String NAME_DELIMITER = ",";

    private final List<Car> cars;

    private RacingCars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public static RacingCars createCars(int numOfCar, MovePolicy movePolicy) {
        List<Car> cars = IntStream.range(0, numOfCar)
                .mapToObj(i -> new Car(movePolicy))
                .collect(Collectors.toList());
        return new RacingCars(cars);
    }

    public static RacingCars createCars(String strCarNames, MovePolicy movePolicy) {
        CarNames carNames = CarNames.createWithDelimiter(strCarNames, NAME_DELIMITER);
        List<Car> cars = IntStream.range(0, carNames.size())
                .mapToObj(index -> new Car(carNames.get(index), movePolicy))
                .collect(Collectors.toList());
        return new RacingCars(cars);
    }

    public static RacingCars createRandomMoveCars(String strCarNames) {
        return createCars(strCarNames, new RandomMovePolicy());
    }

    public void step() {
        cars.forEach(Car::move);
    }

    public List<Integer> getDistanceOfCars() {
        return cars.stream()
                .map(Car::getMovedDistance)
                .collect(Collectors.toList());
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getMostMovingCars() {
        int mostMovingDistance = getMostMovingDistance();
        return cars.stream()
                .filter(car -> car.getMovedDistance() == mostMovingDistance)
                .collect(Collectors.toList());
    }

    private int getMostMovingDistance() {
        return cars.stream()
                .mapToInt(Car::getMovedDistance)
                .max()
                .orElseThrow(() -> new IllegalStateException("자동차 중 거리가 없는 값이 존재합니다."));
    }
}
