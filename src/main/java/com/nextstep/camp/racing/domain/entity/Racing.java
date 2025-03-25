package com.nextstep.camp.racing.domain.entity;

import java.util.List;

import com.nextstep.camp.racing.common.vo.PositiveInteger;
import com.nextstep.camp.racing.domain.vo.*;

public class Racing {

    private final Cars cars;
    private final PositiveInteger lapCount;
    private final LapRecord lapRecord = new LapRecord();

    private Racing(Cars cars, PositiveInteger lapCount) {
        this.cars = cars;
        this.lapCount = lapCount;
    }

    public static Racing initialize(Cars cars, PositiveInteger maxPosition) {
        return new Racing(cars, maxPosition);
    }

    public void start() {
        while (!isFinished()) {
            lapRecord.record(cars);
        }
    }

    private boolean isFinished() {
        return lapRecord.size().equals(lapCount);
    }

    public Cars getCars() {
        return cars;
    }

    public List<Lap> getLaps() {
        return lapRecord.getLaps();
    }
}
