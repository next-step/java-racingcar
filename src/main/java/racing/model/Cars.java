package racing.model;

import racing.strategy.GoStraightStrategy;
import racing.strategy.RandomNumberGoStraightStrategy;
import racing.view.GameOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List<Car> winner = new ArrayList<>();
        Car winnerCar = this.getWinnerCar();
        for (Car car : cars) {
            if (isWinnerLocation(winnerCar, car)) {
                winner.add(car);
            }
        }
        return new Cars(winner);
    }

    public List<Car> getCarList() {
        return this.cars;
    }

    private Car getWinnerCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow();
    }

    private boolean isWinnerLocation(Car winnerCar, Car comparisonCar) {
        return winnerCar.isSameCurrentLocation(comparisonCar);
    }

}
