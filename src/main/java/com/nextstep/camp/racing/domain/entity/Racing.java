package com.nextstep.camp.racing.domain.entity;

import java.util.List;

import com.nextstep.camp.racing.common.vo.PositiveInteger;
import com.nextstep.camp.racing.domain.vo.*;

public class Racing {

    private final Cars cars;
    private final PositiveInteger lapCount;
    private final LapRecord lapRecord;
    private Cars winners;

    private Racing(Cars cars, PositiveInteger lapCount) {
        this.cars = cars;
        this.lapCount = lapCount;
        this.lapRecord = LapRecord.ready();
    }

    public static Racing initialize(Cars cars, PositiveInteger maxPosition) {
        return new Racing(cars, maxPosition);
    }

    public void start() {
        while (!isFinished()) {
            lapRecord.record(cars);
        }
        cars.recordWinners();
        winners = cars.getWinners();
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

    public Cars getWinners() {
        return winners;
    }
}
