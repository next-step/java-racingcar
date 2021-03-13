package step5.domain;


import step5.utils.RandomGenerator;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class CarRacing {

    private Cars cars;

    public CarRacing(String[] drivers) {
        List<Car> cars = IntStream.range(0, drivers.length)
                .mapToObj(i -> new Car(drivers[i], 1))
                .collect(toList());

        this.cars = new Cars(cars);
    }

    public Cars getCurrentStatus() {
        return cars;
    }

    public void moveProgress(RandomGenerator randomGenerator) {
        cars.move(randomGenerator);
    }

    public Winners getWinner() {
        return new Winners(cars.getWinners());
    }
}
