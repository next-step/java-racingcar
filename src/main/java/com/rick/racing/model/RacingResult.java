package com.rick.racing.model;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private final List<CarRecordHistory> carRecordHistories = new ArrayList<>();

    public void addRecord(CarRecordHistory carRecordHistory) {
        carRecordHistories.add(carRecordHistory);
    }

    public int recordPosition(int carIndex, int tryIndex) {
        return carRecordHistories.get(carIndex).getPosition(tryIndex);
    }
}