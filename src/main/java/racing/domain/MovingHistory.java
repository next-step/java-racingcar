package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class MovingHistory {
    private List<Cars> movingHistory;
    
    public MovingHistory() {
        this.movingHistory = new ArrayList<>();
    }
    
    public void addHistory(Cars cars) {
        movingHistory.add(cars);
    }
    
    public List<Cars> getMovingHistory() {
        return movingHistory;
    }
}
