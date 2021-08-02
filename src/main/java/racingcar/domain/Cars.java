package racingcar.domain;

import racingcar.util.RandomGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] carsName) {
        this.cars = createCars(carsName);
    }

    private List<Car> createCars(String[] carsName) {
        return Stream.of(carsName)
                .map(s -> new Car(s))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getCarsSize() {
        return cars.size();
    }

    public Cars carMove() {
        for(Car car : cars) {
            car.move(new RandomNumberMovingStrategy(RandomGenerator.getInstance()));
        }
        return this;
    }

    public List<Car> findWinner() {
        Car winner = cars.get(0);
        List<Car> winners = new ArrayList<>();
        for(Car car : cars) {
            if(car.getPosition() > winner.getPosition() || car.getPosition() == winner.getPosition()) {
                winners.add(car);
            }
        }
        return winners;
    }
}
