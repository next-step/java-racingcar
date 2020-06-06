package racingcar_step4.domain;

import racingcar_step4.model.Car;
import racingcar_step4.model.MovingStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars() {
    }

    public Cars(List<Car> names) {
        this.cars = names;
    }

    public List<Car> runRacing(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
        return cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> rankCars(List<Car> cars) {

        List<Car> winners = new ArrayList<>();

        reverseSortCars(cars);
        Car winner = cars.get(0);
        winners.add(winner);

        for (int i=1; i < cars.size(); i++) {
            checkSameScore(winner, cars.get(i));
        }
        return winners;
    }

    private void reverseSortCars(List<Car> cars) {
        cars.sort(Collections.reverseOrder());
    }

    private void checkSameScore(Car winner, Car otherCar) {
        if (winner.compareTo(otherCar) == 0) {
            cars.add(otherCar);
        }
    }
}
