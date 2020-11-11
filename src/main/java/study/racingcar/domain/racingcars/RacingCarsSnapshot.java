package study.racingcar.domain.racingcars;

import study.racingcar.domain.car.CarSnapshot;

import java.util.List;

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
