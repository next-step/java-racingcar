package com.seok.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Record {

    private List<Integer> record = new ArrayList<>();

    protected void record(int movable) {
        record.add(getLocation() + movable);
    }

    public int getLocation() {
        if(record.isEmpty())
            return 0;
        return record.get(record.size()-1);
    }

    public int get(int idx) {
        return record.get(idx);
    }
}
