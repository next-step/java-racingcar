package com.seok.racing.domain;

import java.util.Iterator;
import java.util.List;

public class Records implements Iterable<Record> {

    private List<Record> records;

    protected Records(List<Record> records) {
        this.records = records;
    }

    @Override
    public Iterator<Record> iterator() {
        return records.iterator();
    }
}
