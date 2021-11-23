package com.sryoondev.racingcar.step3;

import java.util.List;
import java.util.stream.Collectors;

public class Records {
    private final List<Record> records;

    public Records(List<Record> records) {
        this.records = records;
    }

    public List<Record> getRecords() {
        return records;
    }

    public List<Record> findWinners() {
        Record winnerRecord = records.get(0);
        for (Record record : records) {
            winnerRecord = record.getWinner(winnerRecord);
        }
        int maxDistance = winnerRecord.getDistance();
        return records.stream()
                .filter(r -> maxDistance == r.getDistance())
                .collect(Collectors.toList());
    }
}
