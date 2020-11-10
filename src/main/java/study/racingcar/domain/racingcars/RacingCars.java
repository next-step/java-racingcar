package study.racingcar.domain.racingcars;

import study.racingcar.domain.car.Car;
import study.racingcar.domain.car.CarSnapshot;
import study.racingcar.domain.car.CarSnapshotExporter;
import study.racingcar.domain.car.Engine;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 경주에 참여하는 자동차를 보관하고 상태를 관리하는 책임
 */
public class RacingCars {

    private List<Car> cars;
    private Engine engineOfRacingCars;

    public RacingCars(List<Car> cars, Engine engine) {
        this.cars = cars;
        this.engineOfRacingCars = engine;
    }

    public void nextAttempt() {
        for (Car car : cars) {
            car.move(engineOfRacingCars);
        }
    }

    public List<Car> whoIsFrontRunners() {

        int frontPosition = getFrontPosition();

        return cars.stream()
                .filter(car -> car.isCurrentPosition(frontPosition))
                .collect(Collectors.toList());
    }

    private int getFrontPosition() {
        return cars.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .getAsInt();
    }

    public <T> T export(RacingCarsExporter<T> exporter) {
        List<CarSnapshot> carSnapshots = cars.stream()
                .map(car -> car.export(new CarSnapshotExporter()))
                .collect(Collectors.toList());
        exporter.cars(carSnapshots);
        return exporter.build();
    }
}
