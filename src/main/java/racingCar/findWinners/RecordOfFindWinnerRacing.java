package racingCar.findWinners;

import racingCar.interf.MovingStrategy;
import racingCar.RacingCar;
import racingCar.interf.RandomMovingStrategy;
import racingCar.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RecordOfFindWinnerRacing {
    List<RacingCar> records = new ArrayList<>();

    public void enrollCar(String[] carNames){
        for (String name : carNames){
            this.records.add(new RacingCar(name));
        }
    }

    public void runOneRound() {
        for (RacingCar racingCar: this.records) {
            racingCar.move(moving());
        }
    }

    private static MovingStrategy moving(){
        RandomGenerator randomGenerator = new RandomGenerator();
        return new RandomMovingStrategy(randomGenerator);
    }

    public List<RacingCar> recordsOfCars(){
        return this.records;
    }

}
