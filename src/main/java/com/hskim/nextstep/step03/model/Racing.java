package com.hskim.nextstep.step03.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Racing {

    private int racingNo;
    private Map<String, Integer> recordMap;

    public Racing(int racingNo) {

        this.racingNo = racingNo;
        recordMap = new LinkedHashMap<>();
    }

    public void addRecord(RacingCar racingCar) {

        recordMap.put(racingCar.getCarName(), racingCar.getTotalMovedDistance());
    }

    public int getRacingNo() {
        return racingNo;
    }

    public Map<String, Integer> getRecordMap() {
        return recordMap;
    }
}
