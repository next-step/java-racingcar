package racingGame.Business;

import java.util.List;
import racingGame.model.Car;
import racingGame.model.ProgressRecord;

public class Process {
    
    public List<ProgressRecord> run(String[] names, int moves) {
        List<Car> joinCars = new CarFactory().createCars(names);
        List<ProgressRecord> progressRecords = new GameMove(moves).moveCar(joinCars);
        return progressRecords;
    }

}