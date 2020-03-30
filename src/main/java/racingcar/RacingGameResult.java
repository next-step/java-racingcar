package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
    private final List<List<Integer>> result;

    public RacingGameResult(List<List<Integer>> result) {
        this.result = new ArrayList<>(result);
    }

    public int getNumberOfCars() {
        return result.size();
    }

    public List<Integer> getRecordOfCar(int index) {
        return result.get(index);
    }
}
