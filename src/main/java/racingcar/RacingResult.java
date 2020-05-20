package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private List<Cars> results = new ArrayList<>();

    public void add(Cars cars) {
        results.add(cars);
    }

    public int size() {
        return results.size();
    }

    public Cars get(int index) {
        return results.get(index);
    }

    public List<String> getWinners() {
        Cars finalCars = results.get(results.size() - 1);
        return finalCars.getLeaders();
    }
}
