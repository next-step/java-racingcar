package domain;

import strategy.MovableStrategy;

import java.util.*;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveAll(MovableStrategy movableStrategy) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(movableStrategy);
        }
    }

    public List<String> getWinners() {
        Location maxLocation = getMaxLocation();
        return filterWinners(maxLocation);
    }

    private Location getMaxLocation() {
        Location maxLocation = new Location();
        for (Car car : cars) {
            maxLocation = car.max(maxLocation);
        }
        return maxLocation;
    }

    private List<String> filterWinners(Location maxLocation) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            car.isWinner(winners, maxLocation);
        }
        return winners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
