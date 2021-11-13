package com.rick.racing.model;

import java.util.ArrayList;

public class CarRecordHistory extends ArrayList<Integer> {

    public static final int GO_VALUE = 1;
    public static final int STOP_VALUE = 0;

    public void addHistory(boolean isGo) {
        // 이전 시도 기록을 구합니다.
        final int lastRecord = this.size() == 0 ? 0 : this.get(this.size() - 1);
        this.add(lastRecord + (isGo ? GO_VALUE : STOP_VALUE));
    }

    public int getPosition(int index) {
        return this.get(index);
    }
}
