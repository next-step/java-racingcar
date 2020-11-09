package study.racingcar.racingcars;


import study.racingcar.car.Car;
import study.racingcar.car.CarSnapshot;
import study.racingcar.car.CarSnapshotExporter;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarsSnapshotExporter implements RacingCarsExporter<RacingCarsSnapshot> {

    private RacingCarsSnapshot racingCarsSnapshot;

    private List<CarSnapshot> carSnapshots;

    public RacingCarsSnapshotExporter() { }

    @Override
    public void cars(List<CarSnapshot> carSnapshots) {
        this.carSnapshots = carSnapshots;
    }

    @Override
    public RacingCarsSnapshot build() {
        return new RacingCarsSnapshot(carSnapshots);
    }

}
