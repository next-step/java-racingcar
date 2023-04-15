package game;

import car.Cars;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Stage stage;
    private final Cars cars;
    private final List<List<Integer>> result;

    public RacingGame(int carCount, int stageCount) {
        this.stage = Stage.from(stageCount);
        this.cars = Cars.from(carCount);
        this.result = new ArrayList<>();
    }

    public List<List<Integer>> getResults() {
        return result;
    }

    public void progress() {
        while(stage.hasNext()) {
            cars.move();
            stage.next();
            result.add(cars.getPositions());
        }
    }
}
