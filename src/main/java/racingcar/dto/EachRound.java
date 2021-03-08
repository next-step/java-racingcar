package racingcar;

import java.util.HashMap;
import java.util.Map;

public class EachRound {

    private Map<String, Integer> result = new HashMap<>();

    public Map<String, Integer> getResult() {
        return result;
    }

    public void recordRoundPosition(Car car, String carName) {
        result.put(carName, car.getPosition());
    }
}
