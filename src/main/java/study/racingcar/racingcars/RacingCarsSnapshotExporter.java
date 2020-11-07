package study.racingcar.racingcars;


import study.racingcar.car.Car;
import study.racingcar.car.CarSnapshot;
import study.racingcar.car.CarSnapshotExporter;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarsSnapshotExporter implements RacingCarsExporter<RacingCarsSnapshot> {

    private RacingCarsSnapshot racingCarsSnapshot;

    public RacingCarsSnapshotExporter() {
        this.racingCarsSnapshot = new RacingCarsSnapshot();
    }

    @Override
    public void cars(List<Car> cars) {
        List<CarSnapshot> carSnapshots = cars.stream()
                .map(car -> car.export(new CarSnapshotExporter()))
                .collect(Collectors.toList());

        racingCarsSnapshot.setCarSnapshot(carSnapshots);
    }

    @Override
    public RacingCarsSnapshot build() {
        return racingCarsSnapshot;
    }

}
