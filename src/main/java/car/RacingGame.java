package car;

import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final int carCount;
    private final int stageCount;

    public RacingGame(int carCount, int stageCount) {
        this.carCount = carCount;
        this.stageCount = stageCount;
    }

    public void progress() {
        Cars cars = new Cars(createCars());

        ResultView.printResultTitle();
        for(int i = 0; i < stageCount; i++) {
            cars.move();
            ResultView.printCars(cars);
        }
    }

    private List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carCount; i++) {
            cars.add(new Car(0));
        }
        return cars;
    }
}
