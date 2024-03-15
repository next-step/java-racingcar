package carRacing.model;

import java.util.ArrayList;
import java.util.List;

public class RacingRecodes {

    List<RacingCar> records = new ArrayList<>();

    public void registerCar(String[] carNames){
        for (String name : carNames){
            this.records.add(new RacingCar(name));
        }
    }

    public void runOneRound() {
        for (RacingCar racingCar: this.records) {
            racingCar.move(moving());
        }
    }

    private static MoveStrategy moving(){
        RandomGenerator randomGenerator = new RandomGenerator();
        return new RandomMoveStrategy(randomGenerator);
    }

    public List<RacingCar> recordsOfCars(){
        return this.records;
    }


}
