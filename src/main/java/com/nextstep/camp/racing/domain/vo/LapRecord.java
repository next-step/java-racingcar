package com.nextstep.camp.racing.domain.vo;

import java.util.ArrayList;
import java.util.List;

import com.nextstep.camp.racing.common.vo.PositiveInteger;

public class LapRecord {

    private final List<Lap> laps = new ArrayList<>();

    private LapRecord() {
    }

    public static LapRecord ready() {
        return new LapRecord();
    }

    public void record(Cars cars) {
        cars.move();
        List<CarMoves> snapshot = cars.getCarsLapRecord();
        laps.add(new Lap(snapshot));
    }

    public List<Lap> getLaps() {
        return laps;
    }

    public PositiveInteger size() {
        return PositiveInteger.of(laps.size());
    }
}
