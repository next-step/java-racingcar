package racingcar;

import java.util.ArrayList;
import java.util.List;

public class MoveResults {

    private List<CarPositions> results = new ArrayList<>();

    public void add(CarPositions positions) {
        results.add(positions);
    }

    public int size() {
        return results.size();
    }

    public CarPositions get(int index) {
        return results.get(index);
    }

    public List<String> getWinners() {
        CarPositions finalCarPositions = results.get(results.size() - 1);
        return finalCarPositions.getLeaders();
    }
}
