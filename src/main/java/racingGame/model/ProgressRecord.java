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
    
    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < this.joinCarsRecord.size(); i++) {
            int location = this.joinCarsRecord.get(i);
            String name = this.joinCarsName.get(i);
            
            if (location > max) {
                max = location;
                winners.clear();
                winners.add(name);
            } else if (location == max) {
                winners.add(name);
            }
        }
        return winners;
    }
    
    public List<Integer> carRecord() {
        return this.joinCarsRecord;
    }

    public List<String> carName() {
        return this.joinCarsName;
    }
}
