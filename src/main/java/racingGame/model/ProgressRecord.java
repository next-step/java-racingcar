package racingGame.model;

import java.util.ArrayList;
import java.util.List;

public class ProgressRecord {
    private final List<Integer> joinCarsRecord = new ArrayList<>();
    private final List<String> joinCarsName = new ArrayList<>();
    
    public void recordGame(List<Car> cars) {
        for(Car car: cars) {
            this.joinCarsRecord.add(car.findLocation()) ;
            this.joinCarsName.add(car.showName());
        }
    }
    
    public List<Integer> carRecord() {
        return this.joinCarsRecord;
    }

    public List<String> carName() {
        return this.joinCarsName;
    }
}
