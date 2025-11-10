package racingGame.model;

import java.util.ArrayList;
import java.util.List;

public class ProgressRecord {
    private final List<Integer> joinCarsRecord = new ArrayList<>();
    
    public List<Integer> recordGame(List<Car> cars) {
        for(Car car: cars) {
            this.joinCarsRecord.add(car.findLocation()) ;
        }
        return this.joinCarsRecord;
    }
    
    public List<Integer> getRecord() {
        return this.joinCarsRecord;
    }
}
