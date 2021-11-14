package com.sryoondev.racingcar.step3;

import java.util.ArrayList;
import java.util.List;

public class GameRecord {
    private final List<List<Integer>> records;

    public GameRecord() {
        this.records = new ArrayList<>();
    }

    public void add(Circuit circuit) {
        records.add(circuit.getRecords());
    }

    public List<List<Integer>> getRecords() {
        return records;
    }
}
