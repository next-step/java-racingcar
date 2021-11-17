package com.sryoondev.racingcar.step3;

import java.util.ArrayList;
import java.util.List;

public class GameRecord {
    private final List<Records> records;

    public GameRecord() {
        this.records = new ArrayList<>();
    }

    public void add(Circuit circuit) {
        records.add(circuit.getRecords());
    }

    public List<Records> getRecords() {
        return records;
    }
}
