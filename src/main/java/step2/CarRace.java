package step2;

import java.util.ArrayList;
import java.util.List;

public class CarRace {
    private int numberOfCars;
    private int numberOfTrials;

    public CarRace(int numberOfCars, int numberOfTrials) {
        this.numberOfCars = numberOfCars;
        this.numberOfTrials = numberOfTrials;
    }

    public List<Car> makeCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for(int i=0; i<numberOfCars; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public OutputView start() {
        List<Car> cars = makeCars(numberOfCars);
        return new OutputView(cars);
    }
}
