package carRacing.model;

import java.util.ArrayList;
import java.util.List;

public class RacingRecords {
    private final List<RacingCar> records;

    public RacingRecords() {
        this.records = new ArrayList<>();
    }

    public void registerCar(List<String> carNames) {
        for (String name : carNames) {
            this.records.add(new RacingCar(name, 0));
        }
    }
    public List<RacingCar> recordsOfCars(){
        return this.records;
    }

    public List<RacingCar> raceRecord(RandomMoveStrategy strategy) {
        for (RacingCar racingCar : this.records) {
            racingCar.move(strategy);
        }
        return this.records;
    }
}
