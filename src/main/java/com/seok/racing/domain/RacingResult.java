package com.seok.racing.domain;

import java.util.Iterator;
import java.util.List;

public class RacingResult implements Iterable<Records> {

    private List<Records> records;

    protected RacingResult(List<Records> records) {
        this.records = records;
    }

    @Override
    public Iterator<Records> iterator() {
        return records.iterator();
    }
}
