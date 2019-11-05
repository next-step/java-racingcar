package racingCar;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private final List<Integer[]> result = new ArrayList();

    public GameResult() {

    }

    public void add(Integer[] time) {
        result.add(time);
    }

    public List<Integer[]> getTimes() {
        return result;
    }
}
