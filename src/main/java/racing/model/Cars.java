package racing.model;

import racing.strategy.GoStraightStrategy;
import racing.strategy.RandomNumberGoStraightStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void playRound() {
        final GoStraightStrategy randomStraightStrategy = RandomNumberGoStraightStrategy.getInstance();
        for (Car car : cars) {
            car.goStraight(randomStraightStrategy);
        }
    }

    public Cars getWinner() {
        Car winnerCar = this.getWinnerCar();
        final List<Car> winners = cars.stream()
                .filter(it -> winnerCar.isSameCurrentLocation(it))
                .collect(Collectors.toList());
        return new Cars(winners);
    }

    public List<Car> getCarList() {
        return this.cars;
    }

    private Car getWinnerCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow();
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
