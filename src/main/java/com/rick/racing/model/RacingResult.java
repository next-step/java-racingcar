package com.rick.racing.model;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private final List<CarRecordHistory> recordList = new ArrayList<>();

    public void addRecord(CarRecordHistory record) {
        recordList.add(record);
    }

    public CarRecordHistory getRecord(int index) {
        return recordList.get(index);
    }
}