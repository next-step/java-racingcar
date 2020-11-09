package study.racing;

import java.util.LinkedList;

public class RacingRecord {
    private LinkedList<Integer> positionList;

    public RacingRecord(LinkedList<Integer> positionList) {
        this.positionList = positionList;
    }

    public LinkedList<Integer> getPositionList() {
        return positionList;
    }
}
