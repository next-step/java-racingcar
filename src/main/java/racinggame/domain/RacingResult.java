package racinggame.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RacingResult {

    private Map<Integer, List<Car>> racingResults = new TreeMap<>();

    public void saveStepOfRacing(int step, List<Car> cars) {
        racingResults.put(step, cars);
    }

    public Map<Integer, List<Car>> getRacingResults() {
        return Collections.unmodifiableMap(racingResults);
    }

}
