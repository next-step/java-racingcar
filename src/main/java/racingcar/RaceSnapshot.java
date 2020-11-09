package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceSnapshot {
    List<CarSnapshot> carList = new ArrayList<CarSnapshot>();

    public RaceSnapshot(List<CarSnapshot> carList) {
        this.carList = carList;
    }
}
