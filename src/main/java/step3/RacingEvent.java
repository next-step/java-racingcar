package step3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingEvent {

    private List<String> winnerNames = new ArrayList<>();
    private Map<Car, List<Integer>> positionHistory = new HashMap<>();

    Map<Car, List<Integer>> getPositionHistory() {
        return positionHistory;
    }

    void readyEvent(String[] cars){
        for(String name : cars){
            positionHistory.put(new Car(name), new ArrayList<>());
        }
    }

    void startEvent(int tryCount){
        for(int i = 0; i < tryCount; i++){
            moveCars();
        }
    }

    List<String> getWinnersNames(){
        int maxPosition = maxPosition();
        for(Car car : positionHistory.keySet()){
            findWinner(car, maxPosition);
        }

        return winnerNames;
    }

    private void moveCars(){
        positionHistory.forEach((k, v) -> v.add(k.moveForward(new Forward().successForward())));
    }

    private int maxPosition(){
        int max = 0;
        for(Car car : positionHistory.keySet()){
            max = Math.max(max, car.getCurrentPosition());
        }
        return max;
    }

    private void findWinner(Car car, int maxPosition){
        if(maxPosition == car.getCurrentPosition()){
            winnerNames.add(car.getName());
        }
    }

}
