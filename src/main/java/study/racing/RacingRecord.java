package study.racing;

import java.util.LinkedList;

public class RacingRecord {
    private LinkedList<SingleRecord> singleRecords;

    public RacingRecord(LinkedList<SingleRecord> singleRecords) {
        this.singleRecords = singleRecords;
    }

    public LinkedList<SingleRecord> getSingleRecords(){
        return singleRecords;
    }
}

