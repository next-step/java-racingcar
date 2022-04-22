package domain;

public class RunRace {
    private final RaceCondition raceCondition = new RaceCondition();
    private final RaceRecord raceRecord = new RaceRecord();
    private final int raceCount;

    public RunRace(int raceCount) {
        this.raceCount = raceCount;
    }

    public RaceRecord run(String carsName) {
        Cars cars = Cars.builder()
                .carsName(carsName)
                .raceCondition(raceCondition)
                .build();

        for (int count = 0; count < raceCount; count++) {
            raceRecord.addRecord(cars.move());
        }

        return raceRecord;
    }

}
