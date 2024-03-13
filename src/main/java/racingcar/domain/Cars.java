package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.dto.DriveResult;
import racingcar.domain.dto.RoundResult;

public class Cars {

    private final List<Car> cars;

    protected Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("차는 1대 이상이어야 합니다");
        }
        return new Cars(cars);
    }

    public static Cars from(List<String> carNames) {
        return carNames.stream()
            .map(Car::new)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Cars::new));
    }

    public void drive(DrivingStrategy drivingStrategy) {
        for (Car car : cars) {
            car.drive(drivingStrategy);
        }
    }

    public List<Integer> drivingDistances() {
        return cars.stream()
            .map(Car::drivingDistance)
            .collect(Collectors.toList());
    }

    public RoundResult result() {
        List<DriveResult> driveResults = cars.stream()
            .map(Car::driveResult)
            .collect(Collectors.toList());
        return new RoundResult(driveResults);
    }

    public Winners winners() {
        return Winners.from(cars);
    }
}
