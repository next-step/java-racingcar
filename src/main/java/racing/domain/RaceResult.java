package racing.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceResult {

    private static final String NOT_FOUND_RESULT_MESSAGE = " 랩에 통과한 차량이 없습니다";
    private final Map<Integer,List<Car>> resultCars;

    public RaceResult() {
        this.resultCars = new HashMap<>();
    }

    public void setResult(int lap, List<Car> cars) {
        resultCars.put(lap,cars);
    }

    public int getMaxLaps() {
        return resultCars.size();
    }

    public Map<Integer,List<Car>> getResult() {
        return resultCars;
    }

    public List<Car> findResult(int lap) {
        if(resultCars.containsKey(lap)) {
            return resultCars.get(lap);
        }
        throw new NullPointerException(lap+NOT_FOUND_RESULT_MESSAGE);
    }

}
