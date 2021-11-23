package com.sryoondev.racingcar.step3;

import java.util.ArrayList;
import java.util.List;

public class Records {
    private final List<Record> records;

    public Records(List<Record> records) {
        this.records = records;
    }

    public List<Record> getRecords() {
        return records;
    }

    public List<Record> findWinners() {
        int maxDistance = 0;
        for (Record record : records) {
            if (record.getDistance() > maxDistance) {
                maxDistance = record.getDistance();
            }
        }

        List<Record> winners = new ArrayList<>();
        for (Record record : records) {
            if (record.getDistance() == maxDistance) {
                winners.add(record);
            }
        }
        return winners;
    }
}
