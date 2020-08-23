package step3;

import step3.view.ResultView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingEvent {

    private Map<Car, List<Integer>> positionHistory = new HashMap();

    public Map<Car, List<Integer>> getPositionHistory() {
        return positionHistory;
    }

    void readyEvent(int carCount){
        for(int i = 0; i < carCount; i++){
            positionHistory.put(new Car(), new ArrayList<>());
        }
    }

    void startEvent(int tryCount){
        for(int i = 0; i < tryCount; i++){
            moveCars();
        }
    }

    private void moveCars(){
        positionHistory.forEach((k, v) -> v.add(k.moveForward(new Forward().successForward())));
    }

}
