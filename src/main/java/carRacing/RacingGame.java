package carRacing;

import org.assertj.core.util.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    int numberOfCar;
    int time;

    List<Car> cars;
    RacingObserver observe;

    public RacingGame(int numberOfCar, int time) {
        this.numberOfCar = numberOfCar;
        this.time = time;
        cars = new ArrayList<>(setCars());
        observe = new RacingObserver(cars);
    }

    public List<Car> setCars() {
        List<Car> prepareCars = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            prepareCars.add(new Car());
        }
        return prepareCars;
    }

    public void start() {
        for(int i=0; i<time; i++) {
            rotate();
            observe.tracking(cars);
        }
    }

    private void rotate() {
        for(Car car : cars) {
            car.move();
        }
    }

    @VisibleForTesting
    public List<Integer> observe() {
        return observe.observe(cars);
    }

}
