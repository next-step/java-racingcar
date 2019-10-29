package com.seok.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Record {

    private List<Integer> record = new ArrayList<>();

    protected void record(int action) {
        record.add(action);
    }

    public int getTotalDistance() {
        return getCumulativeDistance(record.size());
    }

    public int getCumulativeDistance(int idx) {
        return record.stream().limit(idx+1).mapToInt(i->i).sum();
    }
}
