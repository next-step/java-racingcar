package study.racing.domain;

import java.util.LinkedList;


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
        LinkedList<CarSetInRace> carSetInRaces = new LinkedList<CarSetInRace>();
        cars.getCarSet().forEach(car -> carSetInRaces.add(new CarSetInRace(car.getPosition(), car.getCarName())));
        this.racingRecords.addRecord(new RacingRecord(carSetInRaces));
    }

    public RacingRecords getRecordingResult() {
        return racingRecords;
    }
}
