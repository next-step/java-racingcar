package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    public final List<Car> cars = new ArrayList<Car>();
    private RollStrategy rollStrategy;

    public Race(RollStrategy rollStrategy) {
        this.rollStrategy = rollStrategy;
    }

    public List<Car> createCars(String[] carNames) {
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
        for (Car car : cars) {
            max = car.compareMax(max);
        }
        for (Car car : cars) {
            car.collectWinner(max, winners);
        }
        return winners;
    }

//    public int getMax(int max, Car car) {
//        if (car.isWinner(max)) {
//            return car.;
//        }
//        return max;
//    }


}
