package study.racing;

import java.util.LinkedList;
import java.util.List;


public class RacingGameRounds {

    private int tries;
    private final RacingRecords racingRecords;

    public RacingGameRounds(int tryCnt) {
        this.tries = tryCnt;
        this.racingRecords = new RacingRecords();
    }

    public boolean isEnd() {
        return (tries == 0);
    }

    public void roundClose() {
        tries--;
    }

    public int getTries(){
        return tries;
    }

    public void recording(Cars cars) {
        LinkedList<SingleRecord> singleRecords = new LinkedList<SingleRecord>();
        cars.getCarSet().forEach(car -> singleRecords.add(new SingleRecord(car.getPosition(), car.getCarName())));
        this.racingRecords.addRecord(new RacingRecord(singleRecords));
    }

    public RacingRecords getRecordingResult() {
        return racingRecords;
    }
}
