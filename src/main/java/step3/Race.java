package step3;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private static final int ONE = 1;
    private RacingCarGroup racingCarGroup;
    private List<Record> records;
    private Count finalLap;
    private Count currentLap;

    public Race() {
        currentLap = new Count(ONE);
    }

    public void ready(Count carCount, Count trialCount) {
        records = new ArrayList<>();
        this.racingCarGroup = new RacingCarGroup(carCount);
        this.finalLap = trialCount;
    }

    public List<Record> start() {
        while(currentLap.lessOrEqualsThanOther(finalLap)) {
            racingCarGroup.carsRun();

            records.add(new Record(racingCarGroup.carsCurrentPosition()));
            currentLap.plusCount();
        }

        return records;
    }
}
