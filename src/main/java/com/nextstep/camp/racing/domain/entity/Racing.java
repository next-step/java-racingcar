package com.nextstep.camp.racing.domain.entity;

import java.util.List;

import com.nextstep.camp.racing.common.vo.PositiveInteger;
import com.nextstep.camp.racing.domain.vo.*;

public class Racing {

    private final Cars cars;
    private final PositiveInteger lapCount;
    private final LapHistory lapHistory = new LapHistory();

    private Racing(PositiveInteger carQuantity, PositiveInteger lapCount) {
        this.cars = Cars.of(carQuantity);
        this.lapCount = lapCount;
    }

    public static Racing initialize(PositiveInteger carQuantity, PositiveInteger maxPosition) {
        return new Racing(carQuantity, maxPosition);
    }

    public void start() {
        while (!isFinished()) {
            cars.move();
            lapHistory.record(cars);
        }
    }

    private boolean isFinished() {
        return cars.getMaxPosition().equals(lapCount);
    }

    public Cars getCars() {
        return cars;
    }

    public List<Lap> getLaps() {
        return lapHistory.getLaps();
    }
}
