package step3;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private static final int ONE = 1;
    private RacingCarGroup racingCarGroup;
    private Count finalLap;
    private Count currentLap;

    public Race() {
        currentLap = new Count(ONE);
    }

    public void ready(RacingCarGroup racingCarGroup, Count trialCount) {
        this.racingCarGroup = racingCarGroup;
        this.finalLap = trialCount;
    }

    public List<Record> start() {
        List<Record> records = new ArrayList<>();

        while(currentLap.lessOrEqualsThanOther(finalLap)) {
            racingCarGroup.carsRun();

            records.add(new Record(racingCarGroup.carsCurrentPosition()));
            currentLap.plusCount();
        }

        return records;
    }
}
