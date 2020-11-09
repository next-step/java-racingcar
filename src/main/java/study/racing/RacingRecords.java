package study.racing;


import java.util.LinkedList;


public class RacingRecords {

    private LinkedList<RacingRecord> racingRecords;

    public RacingRecords(){
        racingRecords = new LinkedList<RacingRecord>();
    }
    public void addRecord(RacingRecord racingRecord) {
        racingRecords.add(racingRecord);
    }

    public LinkedList<RacingRecord> getRecordList() {
        return racingRecords;
    }

}
