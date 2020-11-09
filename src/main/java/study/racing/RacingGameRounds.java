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
        List<Car> carSet = cars.getCarSet();
        LinkedList<Integer> positionList = new LinkedList<Integer>();
        carSet.forEach(car -> positionList.add(car.getPosition()));

        RacingRecord racingRecord = new RacingRecord(positionList);

        this.racingRecords.addRecord(racingRecord);

    }

    public RacingRecords getRecordingResult() {
        return racingRecords;
    }
}
