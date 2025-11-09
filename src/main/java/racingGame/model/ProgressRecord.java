package racingGame.model;

import java.util.ArrayList;
import java.util.List;

public class ProgressRecord {
    private final List<Car> joinCarsRecord = new ArrayList<>();
    
    public List<Car> gameRecord(Car car) {
        joinCarsRecord.add(car);
        return joinCarsRecord;
    }
    
    public List<Car> gameResult() {
        return joinCarsRecord;
    }
}
