package racingGame.model;

import java.util.ArrayList;
import java.util.List;

public class ProgressRecord {
    private final List<Car> joinCarsRecord = new ArrayList<>();
    private final List<Integer> simpleResult = new ArrayList<>();
    
    public List<Car> gameRecord(List<Car> cars) {
        joinCarsRecord.addAll(cars);
        this.makeSimpleGameResult();
        return joinCarsRecord;
    }
    
    public List<Car> gameResult() {
        return joinCarsRecord;
    }
    
    private void makeSimpleGameResult() {
        for(Car record: this.joinCarsRecord) {
            simpleResult.add(record.findLocation()) ;
        }
    }
    
    public List<Integer> gameSimpleResult() {
        return simpleResult;
    }
}
