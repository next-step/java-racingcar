package com.nextstep.camp.racing.domain.vo;

import java.util.ArrayList;
import java.util.List;

public class LapHistory {
    private final List<Lap> laps = new ArrayList<>();

    public void record(Cars cars) {
        List<Moves> snapshot = cars.getMovesSnapshot();
        laps.add(new Lap(snapshot));
    }

    public List<Lap> getLaps() {
        return laps;
    }
}
