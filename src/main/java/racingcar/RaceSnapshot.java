package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceSnapshot {
    List<CarSnapshot> cars = new ArrayList<CarSnapshot>();

    public RaceSnapshot(List<CarSnapshot> cars) {
        this.cars = cars;
    }
}
