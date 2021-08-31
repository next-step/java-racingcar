package stage4.domain;

import java.util.*;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(new CarName(carName)));
        }
        this.cars = cars;
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }


    public List<Car> getCars() {
        return this.cars;
    }


    public List<Car> tryRacing() {
        List<Car> results = new ArrayList<>();
        for (Car car : this.cars) {
            car.tryForward(new RandomMovableStrategy());
            results.add(new Car(car));
        }
        return results;
    }

    public void addCars(List<Car> carList) {
        this.cars.addAll(carList);
    }

    public Cars findLastRacingResults(int numberOfCars) {
        final int lastIndex = this.cars.size();
        Collections.unmodifiableList(this.cars.subList(lastIndex - numberOfCars, lastIndex));
        return new Cars(Collections.unmodifiableList(this.cars.subList(lastIndex - numberOfCars, lastIndex)));
    }

    public Cars findWinners() {
        Position maxPosition = this.findMaxPosition();
        Cars winners = new Cars();
        for (Car car : this.cars) {
            winners.addCars(findWinner(maxPosition, car));
        }
        return winners;
    }

    private Position findMaxPosition() {
        Position max = new Position();
        for (Car car : this.cars) {
            max = car.findMaxPosition(max);
        }
        return max;
    }

    private List<Car> findWinner(Position maxPosition, Car car) {
        if (isWinner(maxPosition, car)) {
            return Arrays.asList(car);
        }
        return Arrays.asList();
    }

    private boolean isWinner(Position maxPosition, Car car) {
        return car.isPosition(maxPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cars)) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(getCars(), cars1.getCars());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCars());
    }
}
