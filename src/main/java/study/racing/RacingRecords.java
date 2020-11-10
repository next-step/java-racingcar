package study.racing;


import java.util.*;
import java.util.stream.Collectors;


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

    public List<SingleRecord> getWinners() {
        RacingRecord lastRecord = getLastRecord();

        List<SingleRecord> winners = lastRecord.getSingleRecords().stream()
                .collect(Collectors.groupingBy(
                        SingleRecord::getPosition,
                        TreeMap::new,
                        Collectors.toList()
                ))
                .lastEntry()
                .getValue();


        return winners;
    }

    private RacingRecord getLastRecord() {
        return racingRecords.get(racingRecords.size()-1);
    }
}
