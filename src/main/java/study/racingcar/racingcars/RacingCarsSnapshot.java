package study.racingcar.racingcars;

import study.racingcar.car.Car;
import study.racingcar.car.CarSnapshot;
import study.racingcar.car.CarSnapshotExporter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 데이터 전달 객체(DTO)
 */
public class RacingCarsSnapshot {

    private final List<CarSnapshot> carSnapshot;

    public RacingCarsSnapshot(List<CarSnapshot> carSnapshot) {
        this.carSnapshot = carSnapshot;
    }

    public List<CarSnapshot> getCarSnapshot() {
        return carSnapshot;
    }

}
