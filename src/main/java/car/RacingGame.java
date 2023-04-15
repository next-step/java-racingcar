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
        this.cars = new Cars(createCars(carCount));
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

    private List<Car> createCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
