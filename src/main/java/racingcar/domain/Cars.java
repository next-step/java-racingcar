package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Cars {
    private final List<Car> cars;

    public Cars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        this.cars = cars;
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars moveAllCar() {
        List<Car> carResults = new ArrayList<>();
        for (int carNumber = 0; carNumber < cars.size(); carNumber++) {
            int randomValue = new Random().nextInt(RacingGameConstant.RANDOM_LIMIT);
            carResults.add(cars.get(carNumber).move(new MoveStrategy(randomValue)));
        }
        return new Cars(carResults);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cars)) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
