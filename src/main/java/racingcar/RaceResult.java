package racingcar;

import java.util.List;
import java.util.*;

public class RaceResult {

    private final Map<String,Integer> result = new HashMap<>();

    public RaceResult(List<Car> carList) {
        for (Car car : carList) {
            result.put(car.getName(),car.getDistance());
        }
    }

    public Map<String, Integer> getResult() {
        return result;
    }
}
