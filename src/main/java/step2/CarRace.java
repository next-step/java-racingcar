package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRace {
    private int numberOfCars;
    private int numberOfTrials;

    public CarRace(int numberOfCars, int numberOfTrials) {
        this.numberOfCars = numberOfCars;
        this.numberOfTrials = numberOfTrials;
    }

    private List<Car> makeCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for(int i=0; i<numberOfCars; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    private Car decideMoveOrNot(Car car) {
        if(canMove()) {
            return car.move(1);
        }
        return car.move(0);
    }

    public boolean canMove() {
        Random random = new Random();
        if(random.nextInt(10) >= 4) {
            return true;
        }
        return false;
    }

    public OutputView raceStart() {
        List<Car> cars = makeCars(numberOfCars);
        return new OutputView(cars);
    }
}
