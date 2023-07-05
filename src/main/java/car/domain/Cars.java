package car.domain;

import car.domain.winnerstrategy.WinnerStrategy;
import car.ui.CarFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import utils.random.RandomGenerator;

public class Cars {

    private List<Car> cars;

    public Cars(String names) {
        cars = createCars(names);
    }

    private List<Car> createCars(String names) {
        return Arrays.stream(names.split(","))
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public void move() {
        for (Car car : cars) {
            car.move(RandomGenerator.extractRandomSingleDigit());
        }
    }

    public void print(CarFormatter formatter) {
        cars.forEach(car -> System.out.println(formatter.format(car)));
        System.out.println();
    }

    public List<Car> getWinners(WinnerStrategy winnerStrategy) {
        return winnerStrategy.getWinners(cars);
    }
}
