package carRacing.model;

import java.util.ArrayList;
import java.util.List;

public class RacingRecords {
    private List<RacingCar> records = new ArrayList<>();

        public void registerCar(List<String> carNames) {
        this.records = new ArrayList<>();
        for (String name : carNames) {
            this.records.add(new RacingCar(name, 0));
        }
    }

    private static MoveStrategy moving(){
        RandomGenerator randomGenerator = new RandomGenerator();
        return new RandomMoveStrategy(randomGenerator);
    }

    public List<RacingCar> recordsOfCars(){
        return this.records;
    }

    public List<RacingCar> raceRecord() {
        for (RacingCar racingCar: this.records) {
            racingCar.move(moving());
        }
        return this.records;
    }

}
