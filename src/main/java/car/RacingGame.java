package car;

import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final int stageCount;
    private final Cars cars;

    public RacingGame(int carCount, int stageCount) {
        this.stageCount = stageCount;
        this.cars = new Cars(createCars(carCount));
    }

    public void progress() {
        ResultView.printResultTitle();
        for(int i = 0; i < stageCount; i++) {
            cars.move();
            ResultView.printCars(cars);
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
