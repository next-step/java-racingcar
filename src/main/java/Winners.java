import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {
    private final List<Car> winners;

    Winners(List<Car> candidates) {
        int winnerLocation = findMaxLocation(candidates);
        this.winners = findCarsAtLocation(candidates, winnerLocation);
    }

    List<Car> winners() {
        return Collections.unmodifiableList(this.winners);
    }

    List<String> getNames() {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : winners) {
            winnerNames.add(car.name());
        }
        return winnerNames;
    }

    private static int findMaxLocation(List<Car> cars) {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = car.getMaxLocation(maxLocation);
        }
        return maxLocation;
    }

    private List<Car> findCarsAtLocation(List<Car> cars, int targetLocation) {
        List<Car> locatedCars = new ArrayList<>();
        for (Car car : cars) {
            addIfLocationMatches(locatedCars, car, targetLocation);
        }
        return locatedCars;
    }

    private void addIfLocationMatches(List<Car> locatedCars, Car car, int targetLocation) {
        if (car.isAtLocation(targetLocation)) {
            locatedCars.add(car);
        }
    }
}
