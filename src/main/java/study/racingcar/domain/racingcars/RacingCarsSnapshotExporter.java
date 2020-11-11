package study.racingcar.domain.racingcars;


import study.racingcar.domain.car.CarSnapshot;

import java.util.List;

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
