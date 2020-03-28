package domain;

import strategy.MovableStrategy;

import java.util.*;

public class Cars {
    private static final String NAME_DELIMITER = ",";

    private List<Car> cars;

    public Cars(String names) {
        this.cars = createCars(names);
    }

    public Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    private List<Car> createCars(String names) {
        List<Car> cars = new ArrayList<>();
        for (String name : Arrays.asList(names.split(NAME_DELIMITER))) {
            cars.add(new Car(name));
        }
        return Collections.unmodifiableList(cars);
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
        int maxLocation = getMaxLocation();
        return filterWinners(maxLocation);
    }

    private int getMaxLocation() {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = car.isMaxLocation(maxLocation);
        }
        return maxLocation;
    }

    private List<String> filterWinners(int maxLocation) {
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
