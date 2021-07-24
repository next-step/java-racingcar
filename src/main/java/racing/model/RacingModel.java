package racing.model;

import java.util.HashMap;
import java.util.Map;

public class RacingModel {
    private Map<Integer, Integer> racingModelMap = new HashMap<>();
    private int count = 0;

    public void setCount(int count) {
        this.count = count;
    }
    public void initRacingModelList(int carSize) {
        for(int i=0; i<carSize; i++) {
            racingModelMap.put(i, 0);
        }
    }
    public void setRacingModelMap(int carNumber, int moveCount) {
        racingModelMap.put(carNumber, moveCount);
    }
    public Map<Integer, Integer> getRacingModelMap() {
        return racingModelMap;
    }
    public int getCount() {
        return count;
    }

}
