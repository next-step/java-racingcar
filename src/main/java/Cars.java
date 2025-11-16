import java.util.*;

public class Cars {
    private final List<Car> cars;

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    List<Car> cars() {
        return Collections.unmodifiableList(this.cars);
    }

    void race(Random random, int maxRandomValue) {
        for (Car car : this.cars) {
            car.makeMove(random.nextInt(maxRandomValue));
        }
    }

    Winners winners() {
        Location winnerLocation = findMaxLocation();
        return new Winners(findCarsAtLocation(winnerLocation));
    }

    private Location findMaxLocation() {
        Location maxLocation = new Location(0);
        for (Car car : this.cars) {
            maxLocation = car.location().max(maxLocation);
        }
        return maxLocation;
    }

    private List<Car> findCarsAtLocation(Location targetLocation) {
        List<Car> locatedCars = new ArrayList<>();
        for (Car car : this.cars) {
            addIfLocationMatches(locatedCars, car, targetLocation);
        }
        return locatedCars;
    }

    private void addIfLocationMatches(List<Car> locatedCars, Car car, Location targetLocation) {
        if (car.isAtLocation(targetLocation)) {
            locatedCars.add(car);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cars);
    }
}
