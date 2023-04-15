package game;

import car.Cars;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Stage stage;
    private final Cars cars;
    private final List<GameResult> result;

    public RacingGame(int stageCount, List<String> carNames) {
        this.stage = Stage.from(stageCount);
        this.cars = Cars.from(carNames);
        this.result = new ArrayList<>();
    }

    public List<GameResult> getResults() {
        return result;
    }

    public void progress() {
        while(stage.hasNext()) {
            cars.move();
            stage.next();
            saveResult(cars);
        }
    }

    private void saveResult(Cars cars) {
        List<Integer> positions = cars.getPositions();
        result.add(new GameResult(positions));
    }
}
