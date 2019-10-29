package com.seok.racing.domain;

import java.util.LinkedList;
import java.util.Queue;

public class Record {

    private Queue<Integer> record = new LinkedList<>();

    protected void record(int location) {
        record.offer(location);
    }

    public int next() {
        return record.poll();
    }
}
