package domain;

public class RunRace {
    private final int tryCount;

    public RunRace(int tryCount) {
        this.tryCount = tryCount;
    }

    public RaceRecord run(RaceRecord raceRecord, Cars cars) {
        for (int count = 0; count < tryCount; count++) {
            raceRecord.addRecord(cars.move());
        }
        return raceRecord;
    }

}
