package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    public final Cars cars = new Cars();
    private RollStrategy rollStrategy;

    public Race(RollStrategy rollStrategy) {
        this.rollStrategy = rollStrategy;
    }

    public Cars createCars(String[] carNames) {
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
        return cars;
    }

    public RolledResult roll(Car car) {
        return this.rollStrategy.roll(car);
    }

    public void rollCars() {
        for (Car car : this.cars) {
            roll(car);
        }
    }

    public List<String> findWinners() {
        int max = 1;
        List<String> winners = new ArrayList<String>();
        for (Car car : this.cars) {
            max = car.compareMax(max);
        }
        winners = this.cars.collectWinner(max, winners, this.cars);
        return winners;
    }

}
