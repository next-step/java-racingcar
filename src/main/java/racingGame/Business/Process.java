package racingGame.Business;

import java.util.List;
import racingGame.model.Car;
import racingGame.model.ProgressRecord;

public class Process {
    
    public List<ProgressRecord> run(int cars, int moves) {
        List<Car> joinCars = new CarFactory().createCars(cars);
        List<ProgressRecord> progressRecords = new GameMove(moves).moveCar(joinCars);
        return progressRecords;
    }

}