package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private static final int INITIAL_LOCATION = 0;

    private final Set<Car> cars;

    public Cars(final List<String> names) {
        // TODO: validate?
        this.cars = createCarsFrom(names);
    }

    private Set<Car> createCarsFrom(final List<String> carNames) {
        Set<Car> cars = new LinkedHashSet<>();
        for (String name : carNames) {
            Car car = new Car(name, INITIAL_LOCATION);
            cars.add(car);
        }
        return cars;
    }

    public void moveAll(final MovementCondition movementCondition) {
        for (Car car : cars) {
            car.moveOrStay(movementCondition);
            car.printNameAndCurrentPosition();
        }
        System.out.println();
    }

    public void printWinners() {
        List<String> winners = getWinners();
        System.out.println("최종 우승자: " + String.join(", ", winners));
    }

    private List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int farthest = getFarthestLocation();
        for (Car car : cars) {
            addIfEqualLocation(winners, car, farthest);
        }
        return winners;
    }

    private int getFarthestLocation() {
        int farthestLocation = 0;
        for (Car car : cars) {
            farthestLocation = max(farthestLocation, car);
        }
        return farthestLocation;
    }

    private int max(int farthestLocation, final Car car) {
        if (car.getLocation() > farthestLocation) {
            farthestLocation = car.getLocation();
        }
        return farthestLocation;
    }

    private void addIfEqualLocation(List<String> winners, Car car, int farthest) {
        if (car.getLocation() == farthest) {
            winners.add(car.getName());
        }
    }
}
