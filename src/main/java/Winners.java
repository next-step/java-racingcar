import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {
    private final List<Car> winners;

    Winners(List<Car> candidates) {
        Location winnerLocation = findMaxLocation(candidates);
        this.winners = findCarsAtLocation(candidates, winnerLocation);
    }

    List<Car> winners() {
        return Collections.unmodifiableList(this.winners);
    }

    List<CarName> getNames() {
        List<CarName> winnerNames = new ArrayList<>();
        for (Car car : winners) {
            winnerNames.add(car.name());
        }
        return winnerNames;
    }

    private static Location findMaxLocation(List<Car> cars) {
        Location maxLocation = new Location(0);
        for (Car car : cars) {
            maxLocation = Location.max(car.location(), maxLocation);
        }
        return maxLocation;
    }

    private List<Car> findCarsAtLocation(List<Car> cars, Location targetLocation) {
        List<Car> locatedCars = new ArrayList<>();
        for (Car car : cars) {
            addIfLocationMatches(locatedCars, car, targetLocation);
        }
        return locatedCars;
    }

    private void addIfLocationMatches(List<Car> locatedCars, Car car, Location targetLocation) {
        if (car.isAtLocation(targetLocation)) {
            locatedCars.add(car);
        }
    }
}
