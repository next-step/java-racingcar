package racingGame.model;

import java.util.ArrayList;
import java.util.List;

public class ProgressRecord {
    private final List<Car> joinCarsRecord = new ArrayList<>();
    
    public List<Car> gameRecord(List<Car> cars) {
        joinCarsRecord.addAll(cars);
        return joinCarsRecord;
    }
    
    public List<Car> gameResult() {
        return joinCarsRecord;
    }
}
