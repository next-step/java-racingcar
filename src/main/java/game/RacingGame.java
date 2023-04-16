package game;

import car.Car;
import car.Cars;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Stage stage;
    private final Cars cars;
    private final List<GameResultDto> result;

    public RacingGame(int stageCount, List<String> carNames) {
        this.stage = Stage.from(stageCount);
        this.cars = Cars.from(carNames);
        this.result = new ArrayList<>();
    }

    public List<GameResultDto> getResults() {
        return result;
    }

    public void progress() {
        while(stage.hasNext()) {
            cars.move();
            stage.next();
            saveResult(cars);
        }
    }

    public List<Car> winner() {
        return cars.winners();
    }

    private void saveResult(Cars cars) {
        List<CarDto> positions = cars.getCurrentResult();
        result.add(new GameResultDto(positions));
    }
}
