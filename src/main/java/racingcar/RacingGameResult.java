package racingcar;


import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {

    private final List<int[]> results = new ArrayList<>();
    private Car[] cars;

    public RacingGameResult(Car[] cars) {
        this.cars = cars;
    }

    public void add(int[] records) {
        results.add(records);
    }

    public int getSize() {
        return results.size();
    }
}
