package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.movable.MovableStrategy;
import racingcar.utils.Parser;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromString(final String carNames) {
        final List<Car> cars = Parser.parseCarNames(carNames).stream()
            .map(Car::new)
            .collect(Collectors.toList());

        return new Cars(cars);
    }

    public static Cars fromCarList(final List<Car> cars) {
        return new Cars(cars);
    }

    public CarMoveTurnHistory moveAll(MovableStrategy strategy) {
        CarMoveTurnHistory carMoveTurnHistory = CarMoveTurnHistory.create();
        List<Car> movedCars = new ArrayList<>();

        for (Car car : cars) {
            Car movedCar = car.run(strategy);

            carMoveTurnHistory.add(movedCar);
            movedCars.add(movedCar);
        }

        cars.clear();
        cars.addAll(movedCars);
        return carMoveTurnHistory;
    }

    public List<Car> filterWinners() {
        final int max = calculateMax();

        return cars.stream().filter(car -> car.isEqualDistance(max)).collect(Collectors.toList());
    }

    private int calculateMax() {
        return cars.stream().mapToInt(Car::getDistance).max()
            .orElseThrow(() -> new IllegalArgumentException("최대 이동 거리 값을 구할 수 없습니다."));
    }
}
