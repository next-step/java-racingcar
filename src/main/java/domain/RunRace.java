package domain;

public class RunRace {
    private final RaceCondition raceCondition = new RaceCondition();
    private final RaceRecord raceRecord = new RaceRecord();

    public RaceRecord run(String carsName, int tryCount) {
        Cars cars = Cars.builder()
                .carsName(carsName)
                .raceCondition(raceCondition)
                .build();

        for (int count = 0; count < tryCount; count++) {
            raceRecord.addRecord(cars.move());
        }

        return raceRecord;
    }

}
