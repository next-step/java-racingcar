package racingcar.domain;

import racingcar.util.RandomGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getCarsSize() {
        return cars.size();
    }

    public Cars carMove() {
        for (Car car : cars) {
            car.move(new RandomNumberMovingStrategy(RandomGenerator.getInstance()));
        }
        return this;
    }

    public List<Car> findWinner() {
        List<Car> winners = new ArrayList<>();
        winners.add(cars.stream().max(Comparator.comparingInt(Car::getPosition)).get());

        return winners;
    }
}
