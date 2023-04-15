package car;

import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final int stageCount;
    private final Cars cars;
    private final List<List<Integer>> result;

    public RacingGame(int carCount, int stageCount) {
        this.stageCount = stageCount;
        this.cars = Cars.of(carCount);
        this.result = new ArrayList<>();
    }

    public List<List<Integer>> getResults() {
        return result;
    }

    public void progress() {
        for(int i = 0; i < stageCount; i++) {
            cars.move();
            result.add(cars.getPositions());
        }
    }
}
