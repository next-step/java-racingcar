package com.rick.racing.model;

import java.util.ArrayList;
import java.util.List;

public class CarRecordHistory {

    public static final int GO_VALUE = 1;
    public static final int STOP_VALUE = 0;

    final private List<Integer> positions = new ArrayList<>();

    public void addHistory(boolean isGo) {
        int lastTryRecord = 0;

        if(!positions.isEmpty()) {
            lastTryRecord = positions.get(positions.size() - 1);
        }

        if(isGo) {
            positions.add(lastTryRecord + GO_VALUE);
            return;
        }

        positions.add(lastTryRecord + STOP_VALUE);
    }

    public int getPosition(int index) {
        return positions.get(index);
    }

    public int getSize() {
        return positions.size();
    }

    public boolean isEqual(int index, int value) {
        return positions.get(index).equals(value);
    }
}
